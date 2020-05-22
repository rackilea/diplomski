@Bean
public Jackson2ObjectMapperBuilderCustomizer jackson() {
    return new Jackson2ObjectMapperBuilderCustomizer() {
        @Override
        public void customize(Jackson2ObjectMapperBuilder builder) {
            builder.modules(new JaxbAnnotationModule());
        }
    };
}