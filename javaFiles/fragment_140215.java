private void addFilters(ServletContext container) {
    FilterRegistration.Dynamic registration
            = container.addFilter("u3rAuthentication", DelegatingFilterProxy.class);
    registration.addMappingForUrlPatterns(null, false, "/entry/*");

    registration = container.addFilter("responseXmlFilter", DelegatingFilterProxy.class);
    registration.addMappingForUrlPatterns(null, false, "/entry/*");
}