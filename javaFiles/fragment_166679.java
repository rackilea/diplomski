DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
StringReader xml = new StringReader("<root><A id='1'><B>Blah</B><C>Test</C></A></root>");
Document doc = db.parse(new InputSource(xml));
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("//A");
Element element = doc.createElement("D");
element.setTextContent("new value");
NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for(int i = 0; i < nodes.getLength(); i++) {  
    Node node = nodes.item(i);
    node.appendChild(element);
}