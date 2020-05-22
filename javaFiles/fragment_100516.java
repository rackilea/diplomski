// the XML & search term
String xml = "<foo>" + "<bar>" + "xml java xpath" + "</bar>" + "</foo>";
InputSource src = new InputSource(new StringReader(xml));
final String term = "java";
// search expression and term variable resolver
String expression = "//*[contains(text(),$term)]";
final QName termVariableName = new QName("term");
class TermResolver implements XPathVariableResolver {
  @Override
  public Object resolveVariable(QName variableName) {
    return termVariableName.equals(variableName) ? term : null;
  }
}
// perform the search
XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setXPathVariableResolver(new TermResolver());
Node node = (Node) xpath.evaluate(expression, src, XPathConstants.NODE);