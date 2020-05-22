String xmlInputStr = "<YOUR_XML_STRING_INPUT>"

String xpathExpressionStr = "<XPATH_EXPRESSION_STRING>"

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(xmlInputStr);
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile(xpathExpressionStr);