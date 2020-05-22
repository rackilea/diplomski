public static void main(String[] args) throws IOException {
    String XML="YOUR XML";

    HashMap<String, String> values =convertStringToDocument(XML);
    System.out.println("values = "+values.get("sj1:Source"));
}

public static HashMap<String, String> convertStringToDocument(String xmlStr) {
    HashMap<String, String> values = new HashMap<String, String>();
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
        builder  = factory.newDocumentBuilder();
        EntityResolver resolver = new EntityResolver() {
            public InputSource resolveEntity(String publicId, String systemId) {
                String empty = "";
                ByteArrayInputStream bais = new ByteArrayInputStream(empty.getBytes());
                System.out.println("resolveEntity:" + publicId + "|" + systemId);
                return new InputSource(bais);
            }
        };
        builder.setEntityResolver(resolver);
        Document doc = builder.parse(new InputSource(new ByteArrayInputStream(xmlStr.getBytes("UTF-8"))));
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                values.put(node.getNodeName(), node.getTextContent());
            }
        }

        return values;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}