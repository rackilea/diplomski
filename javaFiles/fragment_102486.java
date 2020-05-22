DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder = factory.newDocumentBuilder();
  InputSource is = new InputSource( new StringReader( xmlString) );
  Document doc = builder.parse( is );

  XPathFactory factory = XPathFactory.newInstance();
  XPath xpath = factory.newXPath();
  xpath.setNamespaceContext(new PersonalNamespaceContext());
  XPathExpression expr = xpath.compile("//src_small/text()");

  Object result = expr.evaluate(doc, XPathConstants.NODESET);
  NodeList nodes = (NodeList) result;
  List<String> urls = new ArrayList<String>();
  for (int i = 0; i < nodes.getLength(); i++) {
      urls.add (nodes.item(i).getNodeValue());
      System.out.println(nodes.item(i).getNodeValue()); 
  }