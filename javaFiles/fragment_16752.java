public class DisallowNullDeserializer<T> extends StdDeserializer<T> implements ResolvableDeserializer {
    private final JsonDeserializer<?> delegateDeserializer;

    public DisallowNullDeserializer(Class<T> clazz, JsonDeserializer<?> delegateDeserializer) {
        super(clazz);
        this.delegateDeserializer = delegateDeserializer;
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // delegate actual deserialization to default deserializer
        T out = (T) delegateDeserializer.deserialize(jp, ctxt);

        // check for null properties & throw exception
        // -> there may be a better, more performant way to find null properties
        Map<String, Object> propertyMap = mapper.convertValue(out, Map.class);
        for (Object property: propertyMap.values())
            if (property == null)
                throw ctxt.mappingException("Can not map JSON null values.");

        return out;
    }

    // there is no obvious reason why this is needed; see linked SO answers 
    @Override
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        ((ResolvableDeserializer) delegateDeserializer).resolve(ctxt);
    }
}