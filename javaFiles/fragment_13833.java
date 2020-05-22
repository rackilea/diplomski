@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper = new ObjectMapper();

    public JacksonContextResolver() {
        mapper.registerModule(new Jackson2HalModule());
        mapper.setHandlerInstantiator(new HalHandlerInstantiator(
                new AnnotationRelProvider(), null, null));
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}