public List<String> generateAbsoluteXpath(File fileToRead, String expressionXPath) throws Exception {
    DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    Document document = documentFactory.newDocumentBuilder().parse(fileToRead);

    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();

    XPathExpression expression = xpath.compile(expressionXPath);
    NodeList result = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

    List<String> generatedXpath = Lists.newArrayList();
    for (int i = 0; i < result.getLength(); i++) {
        generatedXpath.add(getXPath(result.item(i)));
    }
    return generatedXpath;
}



public String getXPath(Node node)
{
    Node parent = node.getParentNode();
    if (parent == null || parent.getNodeName().equals("#document")) {
        return "/" + node.getNodeName();
    }
    return getXPath(parent) + "/" + node.getNodeName();
}