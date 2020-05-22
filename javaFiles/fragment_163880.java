public static void main(String[] args) {
    String exp = "/configs/markets/market";
    String path = "src/a/testConfig.xml";
    try {
        Document xmlDocument = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(path);

        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression = xPath.compile(exp);
        NodeList nodes = (NodeList) xPathExpression.
                evaluate(xmlDocument, XPathConstants.NODESET);

        Document newXmlDocument = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().newDocument();
        Element root = newXmlDocument.createElement("root");
        newXmlDocument.appendChild(root);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Node copyNode = newXmlDocument.importNode(node, true);
            root.appendChild(copyNode);
        }

        printTree(newXmlDocument);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

public static void printXmlDocument(Document document) {
    DOMImplementationLS domImplementationLS = 
        (DOMImplementationLS) document.getImplementation();
    LSSerializer lsSerializer = 
        domImplementationLS.createLSSerializer();
    String string = lsSerializer.writeToString(document);
    System.out.println(string);
}