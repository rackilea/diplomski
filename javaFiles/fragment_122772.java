class CustomChildSerializer extends JsonSerializer<Child> {

    ObjectMapper mapper = new ObjectMapper();
    MapType type = mapper.getTypeFactory().constructMapType(Map.class, String.class, String.class);

    @Override
    public void serialize(Child child, JsonGenerator jgen, SerializerProvider serializerProvider)
            throws IOException, JsonGenerationException {
        Map<String, String> map = mapper.convertValue(child, type);
        map.put("Injected Value", "Value");

        jgen.writeObject(map);
    }

    @Override
    public Class<Child> handledType() {
        return Child.class;
    }
}