public class JacksonMixinModule extends SimpleModule {
    public JacksonMixinModule() {
        super("JacksonMixinModule", new Version(0, 1, 0, "SNAPSHOT"));
    }
    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.setMixInAnnotations(Something.class, Mixin.class);
        context.setMixInAnnotations(Nested.class, NestedMixin.class);
    }
}