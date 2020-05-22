public static void main(String[] args) throws ParserConfigurationException,
        SAXException, IOException {
    InputStream path = new FileInputStream("sample.xml");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(path);
    traverse(document.getDocumentElement());

}

public static void traverse(Node node) {
    NodeList list = node.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
        Node currentNode = list.item(i);
        traverse(currentNode);

    }

    if (node.getNodeName().equals("result")) {
        System.out.println("This -> " + node.getTextContent());
    }

}