String idimlookingfor = "074804007527";

XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();

String xpathexpression = String.format("//TransactionLine/ItemLine/ItemCode[POSCode=%s]/../..", idimlookingfor);
XPathExpression expr = xpath.compile(xpathexpression);

Object result = expr.evaluate(document, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;