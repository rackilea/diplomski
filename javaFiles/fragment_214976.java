public class IgnoreSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String s, 
                          JsonGenerator jsonGenerator, 
                          SerializerProvider serializerProvider) 
                          throws IOException, JsonProcessingException {
        if(!s.equals("IGNORE")) {
            jsonGenerator.writeObject(s);
        }
    }
}