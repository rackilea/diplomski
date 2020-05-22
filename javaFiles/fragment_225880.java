private NodeList findNodes( Object obj, String xPathString )
  throws XPathExpressionException {

  XPath xPath = XPathFactory.newInstance().newXPath();
  XPathExpression expression = xPath.compile( xPathString );
  return (NodeList) expression.evaluate( obj, XPathConstants.NODESET );
}