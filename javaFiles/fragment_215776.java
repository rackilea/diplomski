private static ScheduledExecutorService threadPool;

@Value("${project.threadPoolSize}")
public void setThreadPool(Integer poolSize) {
    threadPool = Executors.newScheduledThreadPool(poolSize);
}