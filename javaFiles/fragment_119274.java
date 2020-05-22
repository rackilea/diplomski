public static void main(String[] args) throws Exception {
    File file = new File("src/main/resources/file.xml");
    XPath xPath =  XPathFactory.newInstance().newXPath();
    String expression = "//*[not(*)]";

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    Document document = builder.parse(file);
    document.getDocumentElement().normalize();

    NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
    for(int i = 0 ; i < nodeList.getLength(); i++) {
        System.out.println(getXPath(nodeList.item(i)));
    }
}

private static String getXPath(Node node) {
    Node parent = node.getParentNode();
    if (parent == null) {
        return node.getNodeName();
    }
    return getXPath(parent) + "/" + node.getNodeName();
}