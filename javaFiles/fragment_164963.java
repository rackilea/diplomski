public AppConfig() {
    packages("com.servicetest.person.resources");
    register(LoggingFilter.class);

    register(SelectableEntityFilteringFeature.class);
    property(SelectableEntityFilteringFeature.QUERY_PARAM_NAME, "select");
    register(JacksonFeature.class);
}