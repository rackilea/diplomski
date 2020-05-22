@Bean
public EndpointHandlerMappingCustomizer mappingCustomizer() {
    return new EndpointHandlerMappingCustomizer() {

        @Override
        public void customize(EndpointHandlerMapping mapping) {
            mapping.setInterceptors(new Object[] { application.executeTimeInterceptor() });
        }

    };
}