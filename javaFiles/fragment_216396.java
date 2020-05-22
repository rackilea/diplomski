XPathFactory xpathFactory = XPathFactory.newInstance();
XPath xpath = xpathFactory.newXPath();
HashMap<String, String> prefMap = new HashMap<>() {{
  put("a", "http://www.w3.org/2005/Atom");
}};
SimpleNamespaceContext namespaces = new SimpleNamespaceContext(prefMap);
xpath.setNamespaceContext(namespaces);
String authors = xpath.evaluate("//a:name)", doc);