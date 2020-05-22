@Context 
private Providers providers;

public String get() {
    ContextResolver<ObjectMapper> contextResolver = 
        providers.getContextResolver(ObjectMapper.class, MediaType.APPLICATION_JSON_TYPE);
    ObjectMapper mapper = someCondition 
        ? contextResolver.getContext(SpecialObjectMapper.class) 
        : contextResolver.getContext(ObjectMapper.class);
    return mapper.writeValueAsString(value);
}