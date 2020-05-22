DocumentBuilderFactory builderFactory = DocumentBuilderFactory
        .newInstance();

// enable namespaces
builderFactory.setNamespaceAware(true);

DocumentBuilder builder = builderFactory.newDocumentBuilder();

Document xmlDocument = builder.parse(file);

XPath xPath = XPathFactory.newInstance().newXPath();

// Set up the namespace context
SimpleNamespaceContext ctx = new SimpleNamespaceContext();
ctx.bindNamespaceUri("ca", "http://www.ca.com/spectrum/restful/schema/response");
xPath.setNamespaceContext(ctx);

System.out.println("*************************");

// corrected expression
String expression = "/ca:alarm-response-list/ca:alarm-responses/ca:alarm/ca:attribute[@id='0x10b5a']";

System.out.println(expression);
NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
        xmlDocument, XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); i++) {
    System.out.println(nodeList.item(i).getTextContent());
}