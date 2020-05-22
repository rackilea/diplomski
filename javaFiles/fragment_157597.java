DocumentBuilderFactory domFactory = DocumentBuilderFactory
        .newInstance();
domFactory.setNamespaceAware(true);

DocumentBuilder builder = domFactory.newDocumentBuilder();
Document doc = builder.parse("blah.pom");
XPath xpath = XPathFactory.newInstance().newXPath();
Map<String, String> namespaces = new HashMap<String, String>();
namespaces.put("pom", "http://maven.apache.org/POM/4.0.0");

xpath.setNamespaceContext(
        new NamespaceContextImpl("http://maven.apache.org/POM/4.0.0", 
                namespaces));

XPathExpression expr = xpath.compile("/pom:project/pom:version");
Object result = expr.evaluate(doc, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;
for (int i = 0; i < nodes.getLength(); i++) {
    System.out.println(nodes.item(i).getTextContent());
}