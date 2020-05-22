String XML =
  "<?xml version = \"1.0\" encoding = \"UTF-8\"?>\n"
      + "<ns0:GetADSLProfileResponse xmlns:ns0 = \"http://\">\n"
      + "  <ns0:Result>\n"
      + "    <ns0:eCode>0</ns0:eCode>\n"
      + "    <ns0:eDesc>Success</ns0:eDesc>\n"
      + "  </ns0:Result>\n"
      + "</ns0:GetADSLProfileResponse> ";
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document document;
try (InputStream in = new ByteArrayInputStream(XML.getBytes(StandardCharsets.UTF_8))) {
  document = builder.parse(in);
}

XPath xPath = XPathFactory.newInstance().newXPath();
XPathExpression expr = xPath.compile("/*[local-name()='GetADSLProfileResponse']/*[local-name()='Result']/*");

NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); i++) {
  Node node = nodeList.item(i);
  System.out.println(node.getNodeName() + ": " + node.getTextContent());
}