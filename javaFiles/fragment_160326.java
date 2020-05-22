DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse("uri to xmlfile");
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("//ep/source[@type]");
NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

for (int i = 0; i < nl.getLength(); i++)
{
    Node currentItem = nl.item(i);
    String key = currentItem.getAttributes().getNamedItem("type").getNodeValue();
    System.out.println(key);
}