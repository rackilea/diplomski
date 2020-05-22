// My Test-XML
final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<root id=\"0\">\n" +
        "\t<sub1 id=\"1\">\n" +
        "\t\t<hell1>hell1</hell1>\n" +
        "\t</sub1>\n" +
        "\t<sub2>\n" +
        "\t\t<hell2 id=\"2\">hell2</hell2>\n" +
        "\t</sub2>\n" +
        "\t<sub3>sub3</sub3>\n" +
        "</root>";
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
// Here you have to put your XML-Source (String, InputStream, File)
        Document doc = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))));
XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xpath = xPathFactory.newXPath();
// The xpath from above
XPathExpression expr = xpath.compile("//*[@id]");
// Here you get the node-list of all elements with an attribute named "id"
NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); i++) {
    // run through all nodes
    Node node = nodeList.item(i);
    // fetch the values from the "id"-attribute
    final String idValue = node.getAttributes().getNamedItem("id").getNodeValue();
    // Do something awesome!!! 
    System.out.println(idValue);
}