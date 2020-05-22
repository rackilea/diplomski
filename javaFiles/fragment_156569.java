JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
jaxbContext.generateSchema(new SchemaOutputResolver() {

    @Override
    public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
        StreamResult streamResult = new StreamResult(new PrintWriter(System.err) {
            @Override
            public void close() {
            }
        });
        streamResult.setSystemId(suggestedFileName);
        return streamResult;
    }
});