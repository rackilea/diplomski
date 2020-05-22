XPath xpath = XPathFactory.newInstance().newXPath();
   // XPath Query for showing all nodes value
  XPathExpression expr = xpath.compile("//testCodeIdentifier/subjectOf/order/subjectOf/annotation/code[@code='SPECIALNOTE']/following-sibling::text/text()");

  Object result = expr.evaluate(doc, XPathConstants.NODESET);
  NodeList nodes = (NodeList) result;
  for (int i = 0; i < nodes.getLength(); i++) {

      System.out.println(nodes.item(i).getNodeValue()); 

  }