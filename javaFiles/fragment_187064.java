public class OnStartupModule extends AbstractModule {
    @Override
    public void configure() {
        bind(OnStartup.class).asEagerSingleton();
    }
}