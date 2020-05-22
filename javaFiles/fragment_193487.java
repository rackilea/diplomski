DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
   documentBuilderFactory.setNamespaceAware(true);
   DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
   Document doc = builder.parse(stream); //input stream of response.

   XPathFactory xPathFactory = XPathFactory.newInstance();
   XPath xpath = xPathFactory.newXPath();

   XPathExpression expr = xpath.compile("//status"); // Look for status tag value.
   String status =  expr.evaluate(doc);
   System.out.println(status);