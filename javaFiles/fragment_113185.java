public class XpathFun
{
    public static void main(String[] args) throws Exception
    {
        String xml = "<xml><level1><level2><![CDATA[ Release Date: 11/20/09 <br />View Trailer ]]></level2></level1></xml>";
        InputSource inputSource = new InputSource(new ByteArrayInputStream(xml.getBytes()));
        System.out.println(XPathFactory.newInstance().newXPath().evaluate("xml/level1/level2", inputSource));
    }
}