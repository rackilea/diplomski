SimpleModule module = new SimpleModule("ExampleDeserializer", 
        new Version(1, 0, 0, null, "com.example", "example-deserializer")); 

ExampleDeserializer exampleDeserializer = new ExampleDeserializer();
module.addDeserializer(Example.class, exampleDeserializer);

ObjectMapper mapper = new ObjectMapper()
                          .registerModule(module)
                          .enable(SerializationFeature.INDENT_OUTPUT);