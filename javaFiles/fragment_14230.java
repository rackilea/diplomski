public class CustomObjectDeserializer extends JsonDeserializer<CustomObject> { 

    @Override
    public CustomObject deserialize(JsonParser jp, DeserializationContext dc) 
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        return new CustomObject("Hello World");
    }
}

@JsonDeserialize(using = CustomObjectDeserializer.class)
public class CustomObject {
    public String message;
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public CustomObject(String message) { this.message = message; }
    public CustomObject(){}
}