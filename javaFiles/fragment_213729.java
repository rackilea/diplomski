public String serialize(Object obj, boolean pretty) {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

    if (pretty) {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    return mapper.writeValueAsString(obj);
}