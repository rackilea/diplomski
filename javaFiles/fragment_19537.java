Class[] classes = new Class[4]; 
classes[0] = org.example.customer_example.AddressType.class; 
classes[1] = org.example.customer_example.ContactInfo.class; 
classes[2] = org.example.customer_example.CustomerType.class; 
classes[3] = org.example.customer_example.PhoneNumber.class; 
JAXBContext jaxbContext = JAXBContext.newInstance(classes);

SchemaOutputResolver sor = new MySchemaOutputResolver();
jaxbContext.generateSchema(sor);