/**
 * Classe quasi completamente copiata dall'equivalente in Spring Data Rest.

 * {@link ValueInstantiator} to create collection or map instances based on the type of the configured
 * {@link PersistentProperty}.
 *
 * @author Oliver Gierke
 */
private static class CollectionValueInstantiator extends ValueInstantiator {

    private final PersistentProperty<?> property;

    /**
     * Creates a new {@link CollectionValueInstantiator} for the given {@link PersistentProperty}.
     *
     * @param property must not be {@literal null} and must be a collection.
     */
    public CollectionValueInstantiator(PersistentProperty<?> property) {

        Assert.notNull(property, "Property must not be null!");
        Assert.isTrue(property.isCollectionLike() || property.isMap(), "Property must be a collection or map property!");

        this.property = property;
    }

    /*
     * (non-Javadoc)
     * @see com.fasterxml.jackson.databind.deser.ValueInstantiator#getValueTypeDesc()
     */
    @Override
    public String getValueTypeDesc() {
        return property.getType().getName();
    }

    /*
     * (non-Javadoc)
     * @see com.fasterxml.jackson.databind.deser.ValueInstantiator#createUsingDefault(com.fasterxml.jackson.databind.DeserializationContext)
     */
    @Override
    public Object createUsingDefault(DeserializationContext ctxt) throws IOException, JsonProcessingException {

        Class<?> collectionOrMapType = property.getType();

        return property.isMap() ? CollectionFactory.createMap(collectionOrMapType, 0)
                : CollectionFactory.createCollection(collectionOrMapType, 0);
    }
}

/**
 * Classe quasi completamente copiata dall'equivalente in Spring Data Rest.
 *
 * Custom {@link JsonDeserializer} to interpret {@link String} values as URIs and resolve them using a
 * {@link UriToEntityConverter}.
 *
 * @author Oliver Gierke
 * @author Valentin Rentschler
 */
private static class UriStringDeserializer extends StdDeserializer<Object> {

    private static final long serialVersionUID = -2175900204153350125L;
    private static final String UNEXPECTED_VALUE = "Expected URI cause property %s points to the managed domain type!";
    private static final TypeDescriptor URI_DESCRIPTOR = TypeDescriptor.valueOf(URI.class);

    private final PersistentProperty<?> property;
    private final ConversionService conversionService;

    /**
     * Creates a new {@link UriStringDeserializer} for the given {@link PersistentProperty} using the given
     * {@link UriToEntityConverter}.
     *
     * @param property must not be {@literal null}.
     * @param converter must not be {@literal null}.
     */
    public UriStringDeserializer(PersistentProperty<?> property, ConversionService conversionService) {

        super(property.getActualType());

        this.property = property;
        this.conversionService = conversionService;
    }

    /*
     * (non-Javadoc)
     * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
     */
    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String source = jp.getValueAsString();

        if (!StringUtils.hasText(source)) {
            return null;
        }

        try {
            URI uri = new UriTemplate(source).expand();
            TypeDescriptor typeDescriptor = TypeDescriptor.valueOf(property.getActualType());

            return conversionService.convert(uri, URI_DESCRIPTOR, typeDescriptor);
        } catch (IllegalArgumentException o_O) {
            throw ctxt.weirdStringException(source, URI.class, String.format(UNEXPECTED_VALUE, property));
        }
    }

    /**
     * Deserialize by ignoring the {@link TypeDeserializer}, as URIs will either resolve to {@literal null} or a
     * concrete instance anyway.
     *
     * @see com.fasterxml.jackson.databind.deser.std.StdDeserializer#deserializeWithType(com.fasterxml.jackson.core.JsonParser,
     *      com.fasterxml.jackson.databind.DeserializationContext,
     *      com.fasterxml.jackson.databind.jsontype.TypeDeserializer)
     */
    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
            throws IOException {
        return deserialize(jp, ctxt);
    }
}