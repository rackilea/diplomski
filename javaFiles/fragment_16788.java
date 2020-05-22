try (InputStream is = new FileInputStream("Test.svg")) {

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document dom = db.parse(is);
    XPath xpath = XPathFactory.newInstance().newXPath();

    // Find the "thing" node...
    javax.xml.xpath.XPathExpression exp = xpath.compile("/svg/g/path[@d]");
    NodeList nl = (NodeList) exp.evaluate(dom, XPathConstants.NODESET);
    for (int index = 0; index < nl.getLength(); index++) {
        Node node = nl.item(index);
        Node dNode = node.getAttributes().getNamedItem("d");
        System.out.println(dNode.getTextContent());
    }

} catch (Exception exp) {
    exp.printStackTrace();
}