Document document;
DocumentBuilderFactory doc_builder_factory = DocumentBuilderFactory.newInstance();
try {
    DocumentBuilder doc_builder = doc_builder_factory.newDocumentBuilder();
    try(InputStream instream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.xml")) {
        document = doc_builder.parse(instream);
    }
} catch(SAXException | ParserConfigurationException e) {
    throw new RuntimeException(e);
}