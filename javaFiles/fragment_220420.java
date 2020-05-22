@Provider
public class QuarkusSmallRyeTracingStandaloneVertxDynamicFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        context.register(StandaloneFilter.class);
    }

    public static class MyFilter implements ContainerRequestFilter {
        // whatever
    }
}