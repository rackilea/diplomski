DocumentBuilderFactory documentBuilderFactory = 
    DocumentBuilderFactory.newInstance();
documentBuilderFactory.setNamespaceAware(true);
Document doc = documentBuilderFactory.newDocumentBuilder().parse(
    new InputSource("data.xml"));

XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(new MyNamespaceContext());
NodeList nodes = (NodeList) xpath.evaluate(
    "//m:parent/doc:header/doc:task/doc:outcome", doc,
    XPathConstants.NODESET);