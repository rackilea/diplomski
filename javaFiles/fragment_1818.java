@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;

    private SpecialObjectMapper specialObjectMapper; // a class extending ObjectMapper

    public JacksonConfig() {
        objectMapper = new ObjectMapper();
        // configuration ...
        specialObjectMapper = new SpecialObjectMapper();
        // configuration with module ...
    }

    @Override
    public ObjectMapper getContext(Class<?> clazz) {
        return clazz == SpecialObjectMapper.class ? specialObjectMapper : objectMapper;
    }

}