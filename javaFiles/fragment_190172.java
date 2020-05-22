@Provider
public class ExampleRequestFilterProvider implements DynamicFeature {

    @Context
    private HttpServletRequest request;

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        ExampleRequestLoggingFilter exampleRequestLoggingFilter = new ExampleRequestLoggingFilter(request);
        featureContext.register(exampleRequestLoggingFilter);
    }

}