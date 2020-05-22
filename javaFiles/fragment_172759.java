public static void main(String[] args) throws SAXException, IOException,
        ParserConfigurationException, TransformerException {

    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
            .newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document document = docBuilder.parse(new File("document.xml"));

    NodeList nodeList = document.getElementsByTagName("*");
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            // do something with the current element
            System.out.println(node.getNodeName());
        }
    }
}