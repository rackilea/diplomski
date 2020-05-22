StreamSource[] xsdSources = new StreamSource[2]; 
    FileInputStream fis1 = new FileInputStream("schema1.xsd"); 
    sources[0] = new StreamSource(fis1); 
    FileInputStream fis2 = new FileInputStream("schema2.xsd"); 
    sources[1] = new StreamSource(fis2); 
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
    Schema schema = schemaFactory.newSchema(xsdSources);
    Validator validator = schema.newValidator();
    validator.validate(new StreamSource(xmlFile));