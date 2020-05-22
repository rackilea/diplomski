public <T> T deserialize(InputStream stream, Class<T> clazz) {
    com.fasterxml.jackson.databind.ObjectMapper mapper = getJsonMapper();
    //Need an instance of Class<MessageWrapper<T>>
    MessageWrapper<T> wrapper =mapper.readValue(jsonString, new TypeReference<MessageWrapper<T>>() {});
    return wrapper.message;
}