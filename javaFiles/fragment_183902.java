@Provider
public class BinderFeature implements Feature {
    @Override
    public boolean configure(FeatureContext ctx) {
        ctx.register(new Binder());
        return true;
    }
}