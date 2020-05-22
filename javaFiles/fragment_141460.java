String emailpath = "//emailAddress";
String emailvalue = ".//value";

XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xpath = xPathFactory.newXPath();
Document document;
public XpathStuff(String file) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = docFactory.newDocumentBuilder();

    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
    document = builder.parse(bis);

    NodeList nodeList = getNodeList(document, emailpath);
    for(int i = 0; i < nodeList.getLength(); i++){
        System.out.println(getValue(nodeList.item(i), emailvalue));
    }
    bis.close();        
}

public NodeList getNodeList(Document doc, String expr) {
    try {
        XPathExpression pathExpr = xpath.compile(expr);
        return (NodeList) pathExpr.evaluate(doc, XPathConstants.NODESET);
    } catch (XPathExpressionException e) {
        e.printStackTrace();
    }
    return null;
}


//extracts the String value for the given expression
private String getValue(Node n, String expr) {
    try {
        XPathExpression pathExpr = xpath.compile(expr);
        return (String) pathExpr.evaluate(n,
                XPathConstants.STRING);
    } catch (XPathExpressionException e) {
        e.printStackTrace();
    }
    return null;
}