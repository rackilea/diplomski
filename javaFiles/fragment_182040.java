private ObjectMapper objectMapper;

@PostConstruct
private void configureObjectMapper() {
    objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
}

@RequestMapping(...)
@ResponseBody
public String getSomething(...) {
    try {
        return objectMapper.writeValueAsString(getSomething());
    } catch (JsonProcessingException e) {
        LOG.error("Could not serialize to JSON", e);
    }
    return null;
}