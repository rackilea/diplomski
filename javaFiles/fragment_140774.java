private static String sourceToXMLString(Source result) throws TransformerConfigurationException, TransformerException {

String xmlResult = null;
try {
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    transformer.transform(result, new StreamResult(out));
    xmlResult = out.toString("UTF-8");
    // or xmlResult = new String(out.toByteArray(), "UTF-8");
} catch (TransformerException e) {
    e.printStackTrace();
}
return xmlResult; 
}