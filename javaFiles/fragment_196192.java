public class XIncludeDemo {

    private static final String XML = "<?xml version=\"1.0\"?>\n"
            + "<data xmlns=\"foo\" xmlns:xi=\"http://www.w3.org/2001/XInclude\">\n"
            + "<xi:include href=\"include.txt\" parse=\"text\"/>\n"
            + "</data>\n";

    private static final String INCLUDE = "Hello, World!";

    public static void main(String[] args) throws Exception {
        // data
        final InputStream xmlStream = new ByteArrayInputStream(XML
                .getBytes("UTF-8"));
        final InputStream includeStream = new ByteArrayInputStream(INCLUDE
                .getBytes("UTF-8"));
        // document parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setXIncludeAware(true);
        factory.setNamespaceAware(true);
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        if (!docBuilder.isXIncludeAware()) {
            throw new IllegalStateException();
        }
        docBuilder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId)
                    throws SAXException, IOException {
                if (systemId.endsWith("include.txt")) {
                    return new InputSource(includeStream);
                }
                return null;
            }
        });
        Document doc = docBuilder.parse(xmlStream);
        // print result
        Source source = new DOMSource(doc);
        Result result = new StreamResult(System.out);
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }

}