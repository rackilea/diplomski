public <T> EventStream<T> deserialize(String value, Class<T> targetClass){
    ObjectMapper mapper = new ObjectMapper();
    JavaType type = mapper.getTypeFactory()
        .constructParametricType(EventStream.class, targetClass);
    try {
        return mapper.readValue(value, type);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}