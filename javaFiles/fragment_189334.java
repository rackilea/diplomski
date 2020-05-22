public String retrieveAttributeValue(Document document, String xpath, String attribute) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
    XPath xPath = XPathFactory.newInstance().newXPath();
    XPathExpression xPathExpression = xPath.compile(xpath + "/" + attribute);
    String attributeValue = "" + xPathExpression.evaluate(document, XPathConstants.STRING);
    return attributeValue;
}