@Bean
public DefaultAnnotationHandlerMapping mapping() {
    DefaultAnnotationHandlerMapping m = new DefaultAnnotationHandlerMapping();
    m.setDetectHandlersInAncestorContexts(true);
    return m;
}