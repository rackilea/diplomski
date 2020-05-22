public <T> T readValue(String content, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
{
    return (T) _readMapAndClose(_jsonFactory.createParser(content), _typeFactory.constructType(valueType));
}

public JavaType constructType(Type type) {
    return _fromAny(null, type, EMPTY_BINDINGS);
}