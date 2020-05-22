public String removeEmptyTags(String xml) {
    try (StringWriter out = new StringWriter()) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource inputXMLSource = new StreamSource(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        StreamSource xsltSource = new StreamSource(getClass().getClassLoader().getResourceAsStream("removeemptytags.xsl"));
        Transformer transformer = transformerFactory.newTransformer(xsltSource);

        transformer.transform(inputXMLSource, new StreamResult(out));
        return out.toString();
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Exception while removing empty tags : ", e);
        throw new ParsingException(e.getMessage());
    }
}