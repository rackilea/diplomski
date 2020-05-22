File schemaFile = new File("pathToXsd");
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    try {
      Schema schema = factory.newSchema(schemaFile);
    } catch (SAXException e) {
      System.out.println("Schema was invalid");
    }
    System.out.println("Schema was valid.");