try {
    File file = new File("text.xml");
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();

    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression xExpress = xpath.compile("//*[@id='1']");
    NodeList nl = (NodeList) xExpress.evaluate(doc, XPathConstants.NODESET);
    System.out.println("Found " + nl.getLength() + " matches");
} catch (Exception e) {
    e.printStackTrace();
}