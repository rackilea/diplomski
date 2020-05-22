static void readData()
throws IOException,
       ParserConfigurationException,
       SAXException {

    DocumentBuilder builder =
        DocumentBuilderFactory.newInstance().newDocumentBuilder();
    URL u = new URL("http://www.aredacao.com.br/tv-saude");
    Document doc = builder.parse(u.toString());
    NodeList nodes = doc.getElementsByTagName("item");
    for (int i = 0; i < nodes.getLength(); i++) {
        Node node = nodes.item(i);
        Element el = (Element) node;

        String title =
            el.getElementsByTagName("title").item(0).getTextContent();
        title = treatCharsAsUtf8Bytes(title);

        String description =
            el.getElementsByTagName("description").item(0).getTextContent();
        description = treatCharsAsUtf8Bytes(description);

        System.out.println("title=" + title);
        System.out.println("description=" + description);
        System.out.println();
    }
}

private static String treatCharsAsUtf8Bytes(String s) {
    byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
    return new String(bytes, StandardCharsets.UTF_8);
}