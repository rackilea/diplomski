public static String transformXML(String xml, InputStream xslFile) {
    String outputXML = null;
    try {
        System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
        Source xmlStream = new StreamSource(new StringReader(xml));
        StringWriter writer = new StringWriter();
        Result result = new StreamResult(writer);
        transformer.transform(xmlStream, result);
        outputXML = writer.getBuffer().toString();
    } catch (TransformerConfigurationException tce) {
        tce.printStackTrace();
    } catch (TransformerException te) {
        te.printStackTrace();
    }
    return outputXML;
}