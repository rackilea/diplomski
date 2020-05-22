private static final ScheduledExecutorService service = new ScheduledThreadPoolExecutor(2);

private static ScheduledFuture<?> scheduleTask(Runnable task, LocalDateTime releaseTime) {
    Duration duration = Duration.between(LocalDateTime.now(), releaseTime);
    return service.schedule(task, duration.toSeconds(), TimeUnit.SECONDS);
}