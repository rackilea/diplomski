public class Response {
  private String status;
  private String error;

  @JsonProperty("p")
  @JsonSerialize(using = CustomSerializer.class)
  private Object data;

  // ...
}

public class CustomSerializer extends JsonSerializer<Object> {
  public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    jgen.writeObjectField(value.getClass().getName(), value);
    jgen.writeEndObject();
  }
}