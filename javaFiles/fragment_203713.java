final XPath xpath = XPathFactory.newInstance().newXPath();
final XPathExpression expr = xpath.compile("//a/bb/c");
final NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); i++) {
    final NamedNodeMap attrs = nodes.item(i).getAttributes();
    final Node dateNode = attrs.getNamedItem("date");
    System.out.println(dateNode.getNodeName() + ":" + dateNode.getNodeValue());
}