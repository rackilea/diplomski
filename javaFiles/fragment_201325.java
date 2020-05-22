@Provides @Singleton
Executor providesExecutor1(ThreadFactory factory) {
    return Executors.newCachedThreadPool(factory)
}

@Provides @Singleton
Executor providesExecutor2(ThreadFactory factory) {
    return Executors.newScheduledThreadPool(10, factory)
}