public class DynamicSchemaTest {

    @XmlRootElement
    public static class A {
        @XmlAttribute(required = true)
        public String name;

        public A() {
        }

        public A(String name) {
            this.name = name;
        }
    }

    @Test(expected = MarshalException.class)
    public void generatesAndUsesSchema() throws JAXBException, IOException,
            SAXException {
        final JAXBContext context = JAXBContext.newInstance(A.class);
        final DOMResult result = new DOMResult();
        result.setSystemId("schema.xsd");
        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri,
                    String suggestedFileName) {
                return result;
            }
        });

        @SuppressWarnings("deprecation")
        final SchemaFactory schemaFactory = SchemaFactory
                .newInstance(WellKnownNamespace.XML_SCHEMA);
        final Schema schema = schemaFactory.newSchema(new DOMSource(result
                .getNode()));

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setSchema(schema);
        // Works
        marshaller.marshal(new A("works"), System.out);
        // Fails
        marshaller.marshal(new A(null), System.out);
    }
}