/**
 * Feature to disable Moxy and Enable Jackson processing
 */
private static class Jackson2Feature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        final String disableMoxy = PropertiesHelper.getPropertyNameForRuntime(
                CommonProperties.MOXY_JSON_FEATURE_DISABLE,
                context.getConfiguration().getRuntimeType());
        context.property(disableMoxy, true);

        // add the default Jackson exception mappers and allow jaxb annotations
        context.register(JsonParseExceptionMapper.class);
        context.register(JacksonJaxbJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        return true;
    }
}