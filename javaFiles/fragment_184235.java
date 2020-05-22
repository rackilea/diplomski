/**
 * Specify a simple matching patterns ("xxx*", "*xxx", "*xxx*" or "xxx*yyy") for
 * {@link org.springframework.integration.endpoint.AbstractEndpoint}
 * bean names to mark them as {@code autoStartup = false}
 * during context initialization.
 * @return the endpoints name patterns to stop during context initialization
 * @see IntegrationEndpointsInitializer
 * @see org.springframework.util.PatternMatchUtils
 */
String[] noAutoStartup() default {};