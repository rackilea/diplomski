private static final String NS0_NS = "http://www.server.com/schemas/TransportationEvent.xsd";
private static final String NS0 = "ns0";
private static final List<String> prefixes = Arrays.asList(NS0);

public void fromDocument(Document doc) throws XPathExpressionException, TransformerConfigurationException,
        TransformerFactoryConfigurationError, TransformerException {

    XPath xpath = XPathFactory.newInstance().newXPath();
    xpath.setNamespaceContext(new NamespaceContext() {

        @Override
        public Iterator getPrefixes(String namespaceURI) {
            return prefixes.iterator();
        }

        @Override
        public String getPrefix(String namespaceURI) {

            String res = namespaceURI.equals(NS0_NS)?NS0:null;
            return res;
        }

        @Override
        public String getNamespaceURI(String prefix) {
            String res = prefix.equals(NS0)?NS0_NS:null;
            return res;
        }
    });

    XPathExpression devex = xpath.compile("//ns0:deviceId[text()='7965145741']/parent::node()");
    Node node = (Node) devex.evaluate(doc,XPathConstants.NODE);

    Transformer xformer = TransformerFactory.newInstance().newTransformer();
    xformer.transform(new DOMSource(node),new StreamResult(System.out));
}