String xml = "<Details><name>sam</name><age>18</age></Details>";
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document xmlDocument = dBuilder.parse(new ByteArrayInputStream(xml
    .getBytes("US-ASCII")));

Element root = xmlDocument.getDocumentElement();
NodeList nodelist = root.getChildNodes();
String[] rowdata = new String[2];
for (int nodeIndex = 0; nodeIndex < nodelist.getLength(); nodeIndex++) {
  Node node = nodelist.item(nodeIndex);

  if (node.getNodeType() == Node.ELEMENT_NODE) {
    System.out.println(node.getNodeName()); // Here we can print the element name
  }

  for (int elementIndex = 0; elementIndex < node.getChildNodes()
      .getLength(); elementIndex++) {

    Node childNode = node.getChildNodes().item(elementIndex);
    rowdata[0] = childNode.getNodeName().toString();
    rowdata[1] = childNode.getTextContent();
    System.out.println(rowdata[0] + " - " + rowdata[1]);
  }
}