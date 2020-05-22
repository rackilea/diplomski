public static String prettyPrintXML(XMLStreamReader xmlStreamReader) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try {
        Transformer serializer = TransformerFactory.newInstance().newTransformer();
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        serializer.transform(new StAXSource(xmlStreamReader), new StreamResult(baos));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    String result = baos.toString();
    try {
        baos.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return result;
}