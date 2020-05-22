@Bean
public ErrorMessageExceptionTypeRouter errorMessageExceptionTypeRouter() {
    ErrorMessageExceptionTypeRouter router = new ErrorMessageExceptionTypeRouter();
    Map<String, String> mappings = new HashMap<>();
    mappings.put(IOException.class.getName(), "directErrorChannel");
    mappings.put(NullPointerException.class.getName(), "directErrorChannel");
    router.setChannelMappings(mappings);
    router.setDefaultOutputChannel(outDefaultChannel());

    return router;
}