SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = sf.newSchema(new File("customer.xsd"));

Validator validator = schema.newValidator();
validator.setErrorHandler(new MyErrorHandler());
validator.validate(source);