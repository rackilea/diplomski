@SuppressWarnings("unchecked")
public <T> T readValue(JsonParser p, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
{
    DeserializationContext ctxt = createDeserializationContext(p);
    return (T) _readValue(ctxt, p, _typeFactory.constructType(valueType));
}