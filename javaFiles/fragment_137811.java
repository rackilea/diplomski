public class UriOrBeanDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer {

    private PersistentProperty<?> property;

    private ConversionService conversionService;

    public UriOrBeanDeserializer(PersistentProperty<?> property, ConversionService conversionService) {
        this.property = property;
        this.conversionService = conversionService;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
            throws JsonMappingException {
        JavaType propertyType = property.getType();
        JavaType contentType = propertyType;
        if (propertyType.isCollectionLikeType()) {
            contentType = propertyType.getContentType();
        }
        JsonDeserializer<Object> delegatee = ctxt.findNonContextualValueDeserializer(contentType);
        UriOrBeanDeserializerInternal objectDeserializer = new UriOrBeanDeserializerInternal(delegatee, new UriStringDeserializer(this.property, conversionService));

        JsonDeserializer<?> result;
        if (propertyType.isCollectionLikeType()) {
            CollectionLikeType collectionType = ctxt.getTypeFactory().constructCollectionLikeType(propertyType.getRawClass(),
                    contentType);
            ValueInstantiator instantiator = new CollectionValueInstantiator(this.property);
            result = new CollectionDeserializer(collectionType, objectDeserializer, null, instantiator);
        } else {
            result = objectDeserializer;
        }

        return result;
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return null;
    }
}