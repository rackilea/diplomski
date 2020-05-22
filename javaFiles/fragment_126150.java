public class RestConfig extends ResourceConfig {

    public RestConfig() {
        packages("org.ambientlight.webservice");

        register(new ContextResolver<ObjectMapper>() {

            @Override
            public ObjectMapper getContext(Class<?> type) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new SwitchableIdModule());
                return objectMapper;
            }
        });
    }
}