SchemaFactory factory = SchemaFactory
                .newInstance("http://www.w3.org/2001/XMLSchema");
        File file = new File("test.xml");
        Schema schema = factory.newSchema(file);

    JAXBContext context = JAXBContext.newInstance(ACCESREFUSE.class);
    Unmarshaller u = context.createUnmarshaller();
    u.setSchema(schema);
    Object anObject = u.unmarshal(new StreamSource(new StringReader(
            getMessage())), ACCESREFUSE.class);