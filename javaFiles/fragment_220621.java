@Test
public void concatXmlDocuments() throws ParserConfigurationException, SAXException, IOException, TransformerException {
    try (
            InputStream doc1 = new ByteArrayInputStream((
                "<headerTag>" + 
                "<tag1>doc1 value</tag1>" + 
                "</headerTag>").getBytes(StandardCharsets.UTF_8));
            InputStream doc2 = new ByteArrayInputStream((
                "<headerTag>" + 
                "<tag1>doc2 value</tag1>" + 
                "</headerTag>").getBytes(StandardCharsets.UTF_8));

        ) {

        org.w3c.dom.Document result = concatXmlDocuments(doc1, doc2);
        String resultXML = toXML(result);
        System.out.printf("%s%n", resultXML);
        NodeList listOfElementsHeaderTag = null;
        System.out.printf("===================================================%n");
        listOfElementsHeaderTag = recoverTheListOfElementsHeaderTag(resultXML);
        printNodeList(listOfElementsHeaderTag);
        System.out.printf("===================================================%n");
        listOfElementsHeaderTag = recoverTheListOfElementsHeaderTag(result);
        printNodeList(listOfElementsHeaderTag);
    }
}


private String toXML(org.w3c.dom.Document result) throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException, IOException {
    String resultXML = null;
    try (ByteArrayOutputStream docR = new ByteArrayOutputStream()) {
        TransformerFactory trf = TransformerFactory.newInstance();
        Transformer tr = trf.newTransformer();
        DOMSource source = new DOMSource(result);
        StreamResult sr = new StreamResult(docR);
        tr.transform(source, sr);
        resultXML = new String(docR.toByteArray(), StandardCharsets.UTF_8);
    }
    return resultXML;
}

private void printNodeList(NodeList nodeList) {
    for(int i = 0; i < nodeList.getLength(); i++) {
        printNode(nodeList.item(i), "");
    }
}

private void printNode(Node node, String startIndent) {
    if(node != null) {
        System.out.printf("%s%s%n", startIndent, node.toString());
        NodeList childNodes = node.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++) {
            printNode(childNodes.item(i), startIndent+ "    ");
        }
    }
}