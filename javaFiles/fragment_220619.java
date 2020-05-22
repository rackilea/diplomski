public org.w3c.dom.Document concatXmlDocuments(InputStream... xmlInputStreams) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    org.w3c.dom.Document result = builder.newDocument();
    org.w3c.dom.Element rootElement = result.createElement("fake");
    result.appendChild(rootElement);
    for(InputStream is : xmlInputStreams) {
        org.w3c.dom.Document document = builder.parse(is);
        org.w3c.dom.Element subRoot = document.getDocumentElement();
        Node importNode = result.importNode(subRoot, true);
        rootElement.appendChild(importNode);
    }
    return result;
}