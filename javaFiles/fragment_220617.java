public org.w3c.dom.Document concatXmlDocuments(String rootElementName, InputStream... xmlInputStreams) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    org.w3c.dom.Document result = builder.newDocument();
    org.w3c.dom.Element rootElement = result.createElement(rootElementName);
    result.appendChild(rootElement);
    for(InputStream is : xmlInputStreams) {
        org.w3c.dom.Document document = builder.parse(is);
        org.w3c.dom.Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++) {
            Node importNode = result.importNode(childNodes.item(i), true);
            rootElement.appendChild(importNode);
        }
    }
    return result;
}