public class Test {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler myHandler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("empty.xml"), myHandler);
    }
}