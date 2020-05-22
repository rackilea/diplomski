// load the Document
Document document = ...;
NamespaceContext ctx = new NamespaceContext() {
    public String getNamespaceURI(String prefix) {
        return prefix.equals("urn") ? "urn:camera-org" : null; 
    }
    public Iterator getPrefixes(String val) {
        return null;
    }
    public String getPrefix(String uri) {
        return null;
    }
};
XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(ctx);
String responseStatus = xpath.evaluate("//urn:ResponseStatus/text()", document);
System.out.println("-> " + responseStatus);