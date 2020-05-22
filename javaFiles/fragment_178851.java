try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document dom = db.parse(new File("Test.xml"));
    XPath xpath = XPathFactory.newInstance().newXPath();

    // Find the "thing" node...
    XPathExpression thingExpr = xpath.compile("/row/field[@name='body']");
    Node body = (Node) thingExpr.evaluate(dom, XPathConstants.NODE);
    if (body != null) {
        System.out.println(body.getTextContent());
    }

} catch (Exception exp) {
    exp.printStackTrace();
}