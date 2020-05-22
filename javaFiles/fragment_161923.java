@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper defaultMapper;

    public ObjectMapperContextResolver() {
        defaultMapper = new ObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("--- getContext ---");
        return defaultMapper;
    }  
}