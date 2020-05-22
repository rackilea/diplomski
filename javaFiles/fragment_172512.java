String filename = "C:\\a.xml";
String expression = "//TextVar";
try {
 Document document = DocumentBuilderFactory.newInstance()
   .newDocumentBuilder().parse(new File(filename));
 NodeList nn = (NodeList) XPathFactory.newInstance().newXPath()
   .evaluate(expression, document, XPathConstants.NODESET);
 for (int i = 0; i < nn.getLength(); i++) {
  Node item = nn.item(i);
  String field = item.getAttributes().getNamedItem("field").getTextContent();
  String number = item.getTextContent();
  System.out.println("field=" + field);
  System.out.println("number=" + number);
 }
} catch (Exception e) {
 throw new RuntimeException(e);
}