@Test
public void testXsd() throws JAXBException, IOException {

    final JAXBContext context = JAXBContext.newInstance(Items.class);

    context.generateSchema(new SchemaOutputResolver() {
        @Override
        public Result createOutput(final String namespaceUri,
                                   final String suggestedFileName)
            throws IOException {
            return new StreamResult(System.out) {
                @Override
                public String getSystemId() {
                    return "noid";
                }
            };
        }
    });
}