public static void main(String[] args) throws Exception {

    Document doc = getDocument(...);

    Map<String, String> namespaceContext = new HashMap<>();
    namespaceContext.put("ns", "urn:iso:std:iso:20022:tech:xsd:camt.054.001.04");

    // Select the first GrpHdr element in document order
    Element element = (Element) select("//ns:GrpHdr[1]", doc, namespaceContext);
    System.out.println(element.asXML());

    // Select the text content of the MsgId element
    Text msgId = (Text) select("./ns:MsgId/text()", element, namespaceContext);
    System.out.println(msgId.getText());

}

static Object select(String expression, Branch contextNode, Map<String, String> namespaceContext) {
    XPath xp = contextNode.createXPath(expression);
    xp.setNamespaceURIs(namespaceContext);
    return xp.evaluate(contextNode);
}