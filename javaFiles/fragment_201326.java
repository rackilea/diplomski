@Provides @Singleton
ExecutorService providesExecutor1(ThreadFactory factory) {
    return Executors.newCachedThreadPool(factory)
}

@Provides @Singleton
ScheduledExecutorService providesExecutor2(ThreadFactory factory) {
    return Executors.newScheduledThreadPool(10, factory)
}