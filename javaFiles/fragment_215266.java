try {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("Test.xml"));
    Node root = doc.getDocumentElement();

    XPath xPath = XPathFactory.newInstance().newXPath();

    XPathExpression xExpress = xPath.compile("//*[@id='n1']");
    NodeList nl = (NodeList)xExpress.evaluate(root, XPathConstants.NODESET);

    System.out.println("Found " + nl.getLength() + " matches");
} catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException ex) {
    ex.printStackTrace();
}