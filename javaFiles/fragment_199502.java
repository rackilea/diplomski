public static void main(String[] args) throws UnsupportedEncodingException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {
    final String xml = "<course name=\"AdvancedAlgorithm\">\n"
            + "    <Teacher name=\"Francis\" class=\"A\" />\n"
            + "    <Teacher name=\"John\" class=\"B\" />\n"
            + "    <Teacher name=\"Philips\" class=\"C\" />\n"
            + "    <course name=\"AlgorithmForBeginners\">\n"
            + "        <Teacher name=\"Simon\" class=\"E\" />\n"
            + "        <Teacher name=\"Joan\" class=\"F\" />\n"
            + "    </course>\n"
            + "    <Teacher name=\"Edward\" class=\"M\" />\n"
            + "</course>";
    final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
    final XPath xPath = XPathFactory.newInstance().newXPath();
    final XPathExpression expression = xPath.compile("//course[@name='AdvancedAlgorithm']//Teacher");

    final NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

    for (int i = 0; i < nodeList.getLength(); ++i) {
        System.out.println(((Element)nodeList.item(i)).getAttribute("name"));
    }
}