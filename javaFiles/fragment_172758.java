public static void main(String[] args) throws SAXException, IOException,
        ParserConfigurationException, TransformerException {

    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
        .newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document document = docBuilder.parse(new File("document.xml"));
    doSomething(document.getDocumentElement());
}

public static void doSomething(Node node) {
    // do something with the current node instead of System.out
    System.out.println(node.getNodeName());

    NodeList nodeList = node.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node currentNode = nodeList.item(i);
        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
            //calls this method for all the children which is Element
            doSomething(currentNode);
        }
    }
}