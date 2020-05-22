private static class UriOrBeanDeserializerInternal extends DelegatingDeserializer {

    private static final long serialVersionUID = 2633089079583425906L;

    private JsonDeserializer<?> uriStringDeserializer;

    public UriOrBeanDeserializerInternal(JsonDeserializer<?> delegatee, JsonDeserializer<?> uriStringDeserializer) {
        super(delegatee);
        this.uriStringDeserializer = uriStringDeserializer;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
            throws JsonMappingException {
        return this;
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonToken token = p.currentToken();
        if (token.isScalarValue()) {
            return uriStringDeserializer.deserialize(p, ctxt);
        }
        return _delegatee.deserialize(p, ctxt);
    }

    @Override
    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> newDelegatee) {
        return new UriOrBeanDeserializerInternal(_delegatee, uriStringDeserializer);
    }

}