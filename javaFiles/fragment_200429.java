XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();
XPathExpression expr = xpath.compile("//div[@id='dvTitle']");
Object result = expr.evaluate(d, XPathConstants.NODE);
Node node = (Node)result;
System.out.println(node.getTextContent());