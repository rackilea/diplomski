public static class DocumentDeserializer extends AsPropertyTypeDeserializer {

    public DocumentDeserializer(final JavaType bt, final TypeIdResolver idRes, final String typePropertyName, final boolean typeIdVisible, final Class<?> defaultImpl) {
        super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl);
    }

    public DocumentDeserializer(final AsPropertyTypeDeserializer src, final BeanProperty property) {
        super(src, property);
    }

    @Override
    public TypeDeserializer forProperty(final BeanProperty prop) {
        return (prop == _property) ? this : new DocumentDeserializer(this, prop);
    }

    @Override
    public Object deserializeTypedFromObject(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.readValueAsTree();
        Class<?> subType =null;
        JsonNode tags = node.get("tags");
        if (tags == null) {
             subType=SuperDocument.class;
        } else {
            subType=SubDocument.class;
        }
        JavaType type = SimpleType.construct(subType);
        JsonParser jsonParser = new TreeTraversingParser(node, jp.getCodec());
        if (jsonParser.getCurrentToken() == null) {
            jsonParser.nextToken();
        }

        JsonDeserializer<Object> deser = ctxt.findContextualValueDeserializer(type, _property);
        return deser.deserialize(jsonParser, ctxt);

    }

}