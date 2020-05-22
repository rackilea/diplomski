private ObjectMapper rootMapper()
{
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    return mapper;
}