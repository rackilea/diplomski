public static void main(String[] args) throws Exception {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("test.xml"));
    sort(doc);

    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    StringWriter writer = new StringWriter();
    transformer.transform(new DOMSource(doc), new StreamResult(writer));

    System.out.println(writer);
}

private static void sort(Node doc) {
    List<Node> children = new ArrayList<>();
    for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
        children.add(doc.getChildNodes().item(i));
    }
    for (Node child : children) {
        doc.removeChild(child);
    }
    Collections.sort(children, (a, b) -> {
        return a.getNodeName().compareTo(b.getNodeName());
    });
    for (Node child : children) {
        doc.appendChild(child);
    }
    for (Node child : children) {
        sort(child);
    }
}