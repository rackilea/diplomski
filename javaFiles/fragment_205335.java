public void removeEmptyTags(Path inFile, Path outFile) {
    try (InputStream in = Files.newInputStream(inFile);
         OutputStream out = Files.newOutputStream(outFile)) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource xsltSource = new StreamSource(getClass().getClassLoader().getResourceAsStream("removeemptytags.xsl"));
        Transformer transformer = transformerFactory.newTransformer(xsltSource);

        transformer.transform(new StreamSource(in), new StreamResult(out));
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Exception while removing empty tags : ", e);
        throw new ParsingException(e.getMessage());
    }
}