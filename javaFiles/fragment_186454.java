@Provider
public class JsonFeature implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.property("jersey.config.server.disableMoxyJson", true);
        // this is in jersey-media-json-jackson
        context.register(JacksonFeature.class);

        // or from jackson-jaxrs-json-provider
        context.register(JacksonJsonProvider.class);
        // for JAXB annotation support
        context.register(JacksonJaxbJsonProvider.class);

        return true;
    }
}