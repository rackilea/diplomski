DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document d = docBuilder.parse("stream.xml");

XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression expr = xpath.compile("//i");

NodeList listOfiNodes = (NodeList) expr.evaluate(d, XPathConstants.NODESET);

for (int i = 0; i < listOfiNodes.getLength(); i++) {
    javax.xml.xpath.XPathExpression expr2 = xpath.compile("c");
    Node item = listOfiNodes.item(i);
    Node node = (Node) expr2.evaluate(item, XPathConstants.NODE);
    if (null != node) {
        System.out.println("> " + node.getTextContent());
    }
}