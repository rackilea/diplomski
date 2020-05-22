public class DelegatingSerializer extends JsonSerializer<String>{

   public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
       JsonSerializer<String> serializer = getSerializer();
       serializer.serialize(value, jgen, provider);      
   }

   private JsonSerializer<String> getSerializer() {
       ...
       return someSerializerInstance;
   }

}