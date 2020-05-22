String xml = "<urn:ResponseStatus version=\"1.0\" xmlns:urn=\"urn:camera-org\">\r\n" + //
        "\r\n" + //
        "<urn:requestURL>/CAMERA/Streaming/status</urn:requestURL>\r\n" + //
        "<urn:statusCode>4</urn:statusCode>\r\n" + //
        "<urn:statusString>Invalid Operation</urn:statusString>\r\n" + //
        "<urn:id>0</urn:id>\r\n" + //
        "\r\n" + //
        "</urn:ResponseStatus>";
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(true);
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));
XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(new NamespaceContext() {
    public String getNamespaceURI(String prefix) {
        return prefix.equals("urn") ? "urn:camera-org" : null;
    }

    public Iterator<?> getPrefixes(String val) {
        return null;
    }

    public String getPrefix(String uri) {
        return null;
    }
});
XPathExpression expr = xpath.compile("//urn:ResponseStatus");
Object result = expr.evaluate(doc, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;
for (int i = 0; i < nodes.getLength(); i++) {
    Node currentItem = nodes.item(i);
    System.out.println("found node -> " + currentItem.getLocalName() + " (namespace: " + currentItem.getNamespaceURI() + ")");
}