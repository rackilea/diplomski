public class MyAppModule extends AbstractModule {
    @Override
    public void configure() {
        bind(EventBus.class).to(AsyncEventBus.class);
    }

    @Provides @Singleton
    ThreadFactory providesThreadFactory() {
        return ThreadManager.currentRequestThreadFactory();
    }

    @Provides @Singleton
    Executor providesExecutor(ThreadFactory factory) {
        return Executors.newCachedThreadPool(factory)
    }

    @Provides @Singleton
    AsyncEventBus providesAsyncEventBus(Executor executor) {
        return new AsyncEventBus(executor);
    }
}