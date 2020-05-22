public class SampleParser {
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\"?>" + //
                "<mods ID=\"id\" version=\"3.3\" xmlns=\"http://www.loc.gov/mods/v3\">" + //
                "<titleInfo></titleInfo>" + //
                "</mods>";
        ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
        XMLReader parser = XMLReaderFactory.createXMLReader(org.apache.xerces.parsers.SAXParser.class.getName());
        parser.setFeature("http://xml.org/sax/features/validation", true);
        parser.setFeature("http://apache.org/xml/features/validation/schema", true);
        parser.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
        parser.setProperty("http://apache.org/xml/properties/internal/entity-resolver", XsdUtils.getResolver());
        parser.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error: " + exception);
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatalError: " + exception);
            }

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("warning: " + exception);
            }
        });
        parser.parse(new InputSource(is));
    }
}