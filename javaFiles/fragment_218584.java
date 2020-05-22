try {
    // Load the document
    DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
    DocumentBuilder b = f.newDocumentBuilder();
    Document original = b.parse(...);

    // Surgically locate the node you're after
    String expression = "/SyncPersonnel/ApplicationArea/BODID";
    XPath xPath = XPathFactory.newInstance().newXPath();
    Node node = (Node) xPath.compile(expression).evaluate(original, XPathConstants.NODE);
    // Get the nodes current text content
    String value = node.getTextContent();
    System.out.println(value);

    // Replace the values
    value = value.replace("sEmployee", "BananaMan").replace("sWUnumber", "007");
    // Set the text content with the new value
    node.setTextContent(value);

    // Save the new document
    try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.METHOD, "xml");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource domSource = new DOMSource(original);
        StreamResult sr = new StreamResult(os);
        tf.transform(domSource, sr);

        String text = new String(os.toByteArray());
        System.out.println(text);

    } catch (TransformerException ex) {
        ex.printStackTrace();
    }

} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | DOMException exp) {
    exp.printStackTrace();
}