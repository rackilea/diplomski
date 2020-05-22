public void xml() throws ParserConfigurationException, SAXException, IOException {
    String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
    msg += "<validateEmail><emailid>abc@gmail.com</emailid><instanceid>instance1</instanceid>";
    msg += "<msgname>validatemsg</msgname><taskid>task1</taskid></validateEmail>";

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document doc = builder.parse(new ByteArrayInputStream(msg.getBytes()));

    Node newNode = doc.createElement("newnode");
    newNode.setTextContent("value");
    Node root = doc.getFirstChild();
    root.appendChild(newNode);

    try {
        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        System.out.println(writer.toString());
    } catch (TransformerException ex) {
        ex.printStackTrace();
    }
}