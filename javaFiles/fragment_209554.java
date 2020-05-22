public class MyRestDispatchModule extends AbstractGinModule {

    static class MyCoreModuleBuilder extends CoreModuleBuilder {
        MyCoreModuleBuilder(BaseRestDispatchModuleBuilder<?> baseBuilder) {
            super(baseBuilder);
            requestBuilderFactory(SecuredRequestBuilderFactory.class);
        }
    }

    static class MyBuilder extends RestDispatchAsyncModule.Builder {
        @Override
        public CoreModuleBuilder core() {
            return new MyCoreModuleBuilder(this);
        }
    }

    @Override
    protected void configure() {
        install(new MyBuilder().build());
    }
}