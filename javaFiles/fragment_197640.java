private SchemaOutputResolver sink;
StringWriter schema;

@Before
public void init() {
    schema = new StringWriter();
    sink = new SchemaOutputResolver() {
        @Override
        public Result createOutput(String namespaceUri,
                String suggestedFileName) throws IOException {
            StreamResult sr = new StreamResult(schema);
            sr.setSystemId("/dev/null");
            return sr;
        }
    };
    Assert.assertTrue(schema.toString().isEmpty());
}

private void testJAXB(Class<?>... classes) throws Exception {
    JAXBContext.newInstance(classes).generateSchema(sink);
    Assert.assertTrue(schema.toString().length() > 0);
}

@Test
public void testJAXBForSpecs() throws Exception {
    testJAXB(Specs.class);
}