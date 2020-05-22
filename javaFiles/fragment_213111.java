public class NodeToString {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        // just to get access to a Node
        String fakeXml = "<!-- Document comment -->\n    <aaa>\n\n<bbb/>    \n<ccc/></aaa>";
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = docBuilder.parse(new InputSource(new StringReader(fakeXml)));
        Node node = doc.getDocumentElement();

        // test the method
        System.out.println(node2String(node));
    }

    static String node2String(Node node) throws TransformerFactoryConfigurationError, TransformerException {
        // you may prefer to use single instances of Transformer, and
        // StringWriter rather than create each time. That would be up to your
        // judgement and whether your app is single threaded etc
        StreamResult xmlOutput = new StreamResult(new StringWriter());
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.transform(new DOMSource(node), xmlOutput);
        return xmlOutput.getWriter().toString();
    }
}