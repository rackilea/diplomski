public void parseAndValidate(File xmlFile, ContentHandler handler) {
    SchemaFactory schemaFactory =
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    schemaFactory.setResourceResolver(new MySchemaResolver());
    Schema schema = schemaFactory.newSchema();

    Validator v = schema.newValidator();
    v.setResourceResolver(schemaFactory.getResourceResolver());

    InputSource is = new InputSource(new FileInputStream(xmlFile));
    v.validate(new SAXSource(is), new SAXResult(handler));
}