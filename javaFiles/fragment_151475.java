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

public static void main(String... args) throws Exception {
  ObjectMapper mapper = new ObjectMapper();
  Response r1 = new Response("Error", "Some error", 20);
  System.out.println(mapper.writeValueAsString(r1));
  Response r2 = new Response("Error", "Some error", "some string");
  System.out.println(mapper.writeValueAsString(r2));
}