public class SomeDeserializer extends JsonDeserializer<Some> {

    @Override
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, ctxt);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Some deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonDeserializer<Object> deserializer = ctxt.findRootValueDeserializer(
                ctxt.getTypeFactory().constructMapType(Map.class, String.class, Object.class));

        return new Some((Map) deserializer.deserialize(jp, ctxt, new HashMap<>()));
    }
}