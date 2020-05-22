/**
 * The target of that deserializer is to do two-step deserialization.
 * At first it just reads string and then does second deserialization in the proper {@link Map} type once string substitution done.
 * <p>
 * Note! In order to get object mapper reference you have to set it first on object mapper initialization stage:
 * </p>
 * <pre>
 *     objectMapper.setInjectableValues(new InjectableValues.Std().addValue(OBJECT_MAPPER_VALUE_ID, objectMapper));
 * </pre>
 */
public class ValueAsMapDeserializer extends JsonDeserializer<Map> implements ContextualDeserializer {
    public static final String OBJECT_MAPPER_VALUE_ID = "objectMapper";
    static final String VALUE_PREFIX = "$|";
    static final String VALUE_SUFFIX = "|";

    private JavaType keyType;
    private JavaType valueType;

    @Override
    public JsonDeserializer<?> createContextual(final DeserializationContext ctxt,
                                                final BeanProperty property) throws JsonMappingException {
        JavaType filedType = property.getType();
        this.keyType = filedType.getKeyType();
        this.valueType = filedType.getContentType();
        return this;
    }

    @Override
    public Map deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        // Can't use constructor init there because of intention to use that deserializer using annotation
        // Also such tricky thing as 'injectable values' was used cause of no way to get the reference to object mapper from deserialization context out of the box
        ObjectMapper objectMapper = (ObjectMapper) ctxt.findInjectableValue(OBJECT_MAPPER_VALUE_ID, null, null);
        final Optional<String> substitutedValue = Substitutor.create(jp, VALUE_PREFIX, VALUE_SUFFIX).substitute();
        MapType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, keyType, valueType);
        return objectMapper.readValue(substitutedValue.orElseThrow(() -> new RuntimeException("Failed to parse the value as map")), mapType);
    }
}