@Test
public void genXmlWithNamespace() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

    String nsURI = "http://example.com/foo";

    DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    doc.setXmlStandalone(true);
    Element root = doc.createElementNS(nsURI, "foo:company");
    doc.appendChild(root);

    root.setAttributeNS(nsURI, "foo:name", "example");

    Element e = null;

    e = doc.createElementNS(nsURI, "foo:employee");
    e.setAttributeNS(nsURI, "foo:id", "1");
    e.setTextContent("John Doe");
    root.appendChild(e);

    e = doc.createElementNS(nsURI, "foo:employee");
    e.setAttributeNS(nsURI, "foo:id", "2");
    e.setTextContent("John Smith");
    root.appendChild(e);

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    Result output = new StreamResult(System.out);
    Source input = new DOMSource(doc);
    transformer.transform(input, output);
}