class MyDeserializer extends StdDeserializer<RectangleDto> {

    public MyDeserializer() {
        this(null);
    }

    protected MyDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public RectangleDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int a = node.get("sideA").intValue();
        int b = node.get("sideB").intValue();
        String useless_parameter = node.get("useless_parameter").asText();

        RectangleDto test = new RectangleDto();
        test.setArea(a * b);
        test.setUseless_parameter(useless_parameter);

        return test;
    }
}