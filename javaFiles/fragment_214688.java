@Bean
public Jackson2ObjectMapperBuilderCustomizer customizer() {
    return new Jackson2ObjectMapperBuilderCustomizer() {
        @Override
        public void customize(Jackson2ObjectMapperBuilder builder) {
            builder.modules(new MyModule());
        }
    };
}

private static class MyModule extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        // Required, as documented in the Javadoc of SimpleModule
        super.setupModule(context);
        context.addDeserializationProblemHandler(new MyDeserializationProblemHandler());
    } 
}

private static class MyDeserializationProblemHandler extends DeserializationProblemHandler {
    @Override
    public boolean handleUnknownProperty(DeserializationContext ctxt,
                                         JsonParser p,
                                         JsonDeserializer<?> deserializer,
                                         Object beanOrClass,
                                         String propertyName)
            throws IOException {
        System.out.println("ahahahaa");
        return super.handleUnknownProperty(ctxt, p, deserializer, beanOrClass, propertyName);
    }
}