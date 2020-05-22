public static void main(String[] args) throws ParserConfigurationException,
        SAXException, IOException {
    String xml = "<div class='video yt'><div class='yt_url'>http://www.youtube.com/watch?v=U_QLu_Twd0g&feature=abcde_gdata</div></div>";
    SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
    XMLReader xmlReader = saxParser.getXMLReader();
    MyHandler myHandler = new MyHandler();
    xmlReader.setContentHandler(myHandler);
    xmlReader.setErrorHandler(myHandler);
    xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler",
            myHandler);
    xmlReader.setFeature(
            "http://apache.org/xml/features/continue-after-fatal-error",
            true);
    xmlReader.parse(new InputSource(new StringReader(xml)));
}