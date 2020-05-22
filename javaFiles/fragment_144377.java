public static Document loadXMLFromString(String xml) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputSource is = new InputSource(new StringReader(xml));
    return builder.parse(is);
}

@Test
public void test() throws Exception {
    Document doc = loadXMLFromString("<test>\n" +
            "  <elem>b</elem>\n" +
            "  <elem>a</elem>\n" +
            "</test>");
    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();
    XPathExpression expr = xpath.compile("//test//elem");
    NodeList all = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    List<String> values = new ArrayList<>();
    if (all != null && all.getLength() > 0) {
        for (int i = 0; i < all.getLength(); i++) {
            values.add(all.item(i).getTextContent());
        }
    }
    Set<String> expected = new HashSet<>(Arrays.asList("a", "b"));
    assertThat("List equality without order",
            values, containsInAnyOrder(expected.toArray()));
}