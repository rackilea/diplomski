public static List<String> loadChapters(Document xmlDoc, String name) throws XPathExpressionException {
    List<String> results = new ArrayList<>(25);
    XPathFactory xf = XPathFactory.newInstance();
    XPath xPath = xf.newXPath();

    String query = "/subjects/subject[sname[text()='" + name + "']]/chapter/@name";
    XPathExpression xExp = xPath.compile(query);
    NodeList nl = (NodeList) xExp.evaluate(xmlDoc, XPathConstants.NODESET);
    for (int index = 0; index < nl.getLength(); index++) {
        Node node = nl.item(index);
        results.add(node.getNodeValue());
    }
    return results;
}