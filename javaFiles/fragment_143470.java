XPathExpression expr = xpath.compile("//Core.Reference");
NodeList list= (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < list.getLength(); i++) {
    Node node = list.item(i);
    System.out.println(node.getTextContent());
    // work with node