@Module(injects = OneActivity.class, includes = ProviderModule.class)
public class OneActivityModule {
    @Provides
    @Named("one")
    public ToInject provideToInject(ToInject toInject) {
        toInject.text = "overridden by one";

        return toInject;
    }
}