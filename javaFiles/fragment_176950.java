class LevelJsonSerializer extends JsonSerializer<Level> {

    @Override
    public void serialize(Level value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getName());
    }
}

class LevelJsonDeserializer extends JsonDeserializer<Level> {

    @Override
    public Level deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String name = p.getText();

        return Level.parse(name);
    }
}