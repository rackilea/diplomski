public class JacksonEnum {

    public static enum DataType {
        JSON, HTML
    }

    public static void main(String[] args) throws IOException {
        List<DataType> types = Arrays.asList(JSON, HTML);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<Enum> modifyEnumDeserializer(DeserializationConfig config,
                                                              final JavaType type,
                                                              BeanDescription beanDesc,
                                                              final JsonDeserializer<?> deserializer) {
                return new JsonDeserializer<Enum>() {
                    @Override
                    public Enum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                        Class<? extends Enum> rawClass = (Class<Enum<?>>) type.getRawClass();
                        return Enum.valueOf(rawClass, jp.getValueAsString().toUpperCase());
                    }
                };
            }
        });
        module.addSerializer(Enum.class, new StdSerializer<Enum>(Enum.class) {
            @Override
            public void serialize(Enum value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString(value.name().toLowerCase());
            }
        });
        mapper.registerModule(module);
        String json = mapper.writeValueAsString(types);
        System.out.println(json);
        List<DataType> types2 = mapper.readValue(json, new TypeReference<List<DataType>>() {});
        System.out.println(types2);
    }
}