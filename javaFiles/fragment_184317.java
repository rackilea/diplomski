//read the XML into a DOM
StreamSource source = new StreamSource(new StringReader("<theXml></theXml>"));
DOMResult result = new DOMResult();
Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.transform(source, result);
Node root = result.getNode();

//make XPath object aware of namespaces
XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(new NamespaceContext(){
    @Override
    public String getNamespaceURI(String prefix) {
        if ("atom".equals(prefix)){
            return "http://www.w3.org/2005/Atom";
        }
        return null;
    }

    @Override
    public String getPrefix(String namespaceURI) {
        return null;
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }
});

//get all summaries
NodeList summaries = (NodeList) xpath.evaluate("/atom:feed/atom:entry/atom:summary", root, XPathConstants.NODESET);
for (int i = 0; i < summaries.getLength(); ++i) {
    Node summary = summaries.item(i);

    //print out all the attributes
    for (int j = 0; j < summary.getAttributes().getLength(); ++j) {
        Node attr = summary.getAttributes().item(j);
        System.out.println(attr.getNodeName() + "=" + attr.getNodeValue());
    }

    //print text content
    System.out.println(summaries.item(i).getTextContent());
}