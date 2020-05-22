JsonFactory jfactory = new JsonFactory();
   JsonGenerator jGenerator = jfactory.createJsonGenerator(new File("test.json"), JsonEncoding.UTF8);
   jGenerator.setPrettyPrinter(new MinimalPrettyPrinter("")); 
    for(int i=0;i<4;i++)
    {
       jGenerator.writeStartObject();
       jGenerator.writeStringField("name" , "test");
       jGenerator.writeEndObject();
       jGenerator.writeRaw('\n');
    }
    jGenerator.close();