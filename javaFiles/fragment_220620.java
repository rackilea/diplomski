public NodeList recoverTheListOfElementsHeaderTag(String xml) throws ParserConfigurationException, SAXException, IOException {
    NodeList listOfElementsHeaderTag = null;
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    try (InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
        listOfElementsHeaderTag = recoverTheListOfElementsHeaderTag(builder.parse(is));
    }
    return listOfElementsHeaderTag;
}

public NodeList recoverTheListOfElementsHeaderTag(org.w3c.dom.Document doc) {
    org.w3c.dom.Element root = doc.getDocumentElement();
    return root.getChildNodes();
}