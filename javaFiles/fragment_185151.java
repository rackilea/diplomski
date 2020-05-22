private static List<String> findNames(Document doc)
                                           throws XPathExpressionException {
  XPath xpath = XPathFactory.newInstance().newXPath();
  NodeList nodes = (NodeList) xpath.evaluate("/process/p", doc, 
                                                    XPathConstants.NODESET);
  List<String> names = new ArrayList<String>();
  for (int i = 0; i < nodes.getLength(); i++) {
    names.add(nodes.item(i).getTextContent());
  }
  return names;
}