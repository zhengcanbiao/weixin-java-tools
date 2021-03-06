package me.chanjar.weixin.mp.bean;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxMpXmlOutImageMessageTest {

  public void test() {
    WxMpMpXmlOutImageMessage m = new WxMpMpXmlOutImageMessage();
    m.setMediaId("ddfefesfsdfef");
    m.setCreateTime(1122l);
    m.setFromUserName("from");
    m.setToUserName("to");
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" 
        + "<xml>"
        + "<ToUserName><![CDATA[to]]></ToUserName>"
        + "<FromUserName><![CDATA[from]]></FromUserName>"
        + "<CreateTime>1122</CreateTime>"
        + "<MsgType><![CDATA[image]]></MsgType>"
        + "<Image><MediaId><![CDATA[ddfefesfsdfef]]></MediaId></Image>"
        + "</xml>";
    System.out.println(m.toXml());
    Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
  }
  
  public void testBuild() {
    WxMpMpXmlOutImageMessage m = WxMpXmlOutMessage.IMAGE().mediaId("ddfefesfsdfef").fromUser("from").toUser("to").build();
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" 
        + "<xml>"
        + "<ToUserName><![CDATA[to]]></ToUserName>"
        + "<FromUserName><![CDATA[from]]></FromUserName>"
        + "<CreateTime>1122</CreateTime>"
        + "<MsgType><![CDATA[image]]></MsgType>"
        + "<Image><MediaId><![CDATA[ddfefesfsdfef]]></MediaId></Image>"
        + "</xml>";
    System.out.println(m.toXml());
    Assert.assertEquals(
              m
                .toXml()
                .replaceAll("\\s", "")
                .replaceAll("<CreateTime>.*?</CreateTime>", ""), 
              expected
                .replaceAll("\\s", "")
                .replaceAll("<CreateTime>.*?</CreateTime>", "")
              );
    
  }
}
