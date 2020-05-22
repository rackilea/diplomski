InputStream input = url.openStream();
   DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
   Document XMLInfo = builder.parse(input);

  XPath xPath = XPathFactory.newInstance().newXPath();
  Node myNode = xPath.evaluate("/lab[@id='2']", XMLInfo, XPathConstants.NODESET);