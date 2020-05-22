class Foo {
    @JsonSerialize(using = MySerializer.class)
    private List<String> fooElements;
}

public class MySerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        List<String> fooList = (List<String>) value;

        if (fooList.isEmpty()) {
            return;
        }

        String fooValue = fooList.get(0);
        String[] fooElements = fooValue.split(",");

        jgen.writeStartArray();
        for (String fooValue : fooElements) {
            jgen.writeString(fooValue);
        }
        jgen.writeEndArray();
    }
}