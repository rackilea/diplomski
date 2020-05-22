public class MapDeserializer extends JsonDeserializer implements ContextualDeserializer {

    private JavaType type;

    public MapDeserializer() {
    }

    public MapDeserializer(JavaType type) {
        this.type = type;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        //beanProperty is null when the type to deserialize is the top-level type or a generic type, not a type of a bean property
        JavaType type = deserializationContext.getContextualType() != null 
            ? deserializationContext.getContextualType()
            : beanProperty.getMember().getType();            
        return new MapDeserializer(type);
    }

    @Override
    public Map deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        //use this.type as needed
    }

    ...
}