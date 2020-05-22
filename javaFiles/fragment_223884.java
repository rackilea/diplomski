public class ClientResponseSchemaValidatingInterceptor extends AbstractSoapInterceptor {

private Marshaller marshaller= null;

public ClientResponseSchemaValidatingInterceptor() {
    super(Phase.PRE_INVOKE);

    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    try {
        Schema schema =
            schemaFactory.newSchema(this.getClass().getClassLoader().getResource("schema/your-xsd.xsd"));

        marshaller = JAXBContext.newInstance(YourModelClass.class).createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    } catch (SAXException | JAXBException ex) {
        log.error("Error creating marshaller",ex);
    }

}

@Override
public void handleMessage(SoapMessage message) {
    List contents = message.getContent(List.class);

    if (contents!=null){
        String responseType = contents.get(0).getClass().getSimpleName();
        try {
              marshaller.marshal(contents.get(0), new DefaultHandler())
            }
        } catch (JAXBException ex){
            log.info("Failed validation",ex);
            throw new RuntimeException("Validation Error");
        }
    }
}