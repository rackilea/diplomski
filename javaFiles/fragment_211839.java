public class KeySerializer extends SerializerBase<Object> {
    private static final SerializerBase<Object> DEFAULT = new StdKeySerializer();

    private Set<Class<?>> objectKeys_ = Collections.synchronizedSet(new HashSet<Class<?>>());

    protected KeySerializer(Class<?>... objectKeys) {
        super(Object.class);
        for(Class<?> cl:objectKeys) {
            objectKeys_.add(cl);
        }
    }


    @Override
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
        return DEFAULT.getSchema(provider, typeHint);
    }


    @Override
    public void serialize(Object value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonGenerationException {
        if (objectKeys_.contains(value.getClass())) {
            ObjectMapper mapper = new ObjectMapper();
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, value);
            jgen.writeFieldName(writer.toString());
        } else {
            DEFAULT.serialize(value, jgen, provider);
        }
    }
}