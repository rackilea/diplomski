public SoapValidatingProcessor(CamelContext context) {
    validatingProcessor = new ValidatingProcessor();
    validatingProcessor.setFailOnNullHeader(false);
    validatingProcessor.setFailOnNullBody(false);

    Resource validationSchema = context.getApplicationContext().getResource(SCHEMA);
    validatingProcessor.setSchemaUrl(validationSchema.getURL());
    validatingProcessor.loadSchema();

    /* Creating a new SchemaFactory instance */
    SchemaFactory xmlSchema = SchemaFactory
        .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);   

    validatingProcessor.setSchemaFactory(xmlSchema);    
}