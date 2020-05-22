@Test
public void concatXmlDocuments() throws ParserConfigurationException, SAXException, IOException, TransformerException {
    try (
            InputStream doc1 = new ByteArrayInputStream((
                "<headerTag>\r\n" + 
                "    <tag1>doc1 value</tag1>\r\n" + 
                "</headerTag>").getBytes(StandardCharsets.UTF_8));
            InputStream doc2 = new ByteArrayInputStream((
                "<headerTag>\r\n" + 
                "    <tag1>doc2 value</tag1>\r\n" + 
                "</headerTag>").getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream docR = new ByteArrayOutputStream();

        ) {

        org.w3c.dom.Document result = concatXmlDocuments("headerTag", doc1, doc2);
        TransformerFactory trf = TransformerFactory.newInstance();
        Transformer tr = trf.newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(result);
        StreamResult sr = new StreamResult(docR);
        tr.transform(source, sr);
        System.out.print(new String(docR.toByteArray(), StandardCharsets.UTF_8));
    }
}