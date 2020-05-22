public class MyResolver implements ContextResolver<ObjectMapper> {

@Override
    public ObjectMapper getContext(final Class<?> objectType) {
        ...            
        return objectMapper;
    }
}