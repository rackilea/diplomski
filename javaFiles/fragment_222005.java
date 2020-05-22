class TestSerializer extends JsonSerializer<Integer> {
    @Override
    public void serialize(Integer value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(value + "." + value);
    }
}
...
@JsonSerialize(using = TestSerializer.class)
private int test;