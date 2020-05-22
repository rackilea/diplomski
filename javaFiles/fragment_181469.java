private final Map<Object, ScheduledFuture<?>> scheduledTasks =
        new IdentityHashMap<>();

@Scheduled(fixedRate = 2000)
public void fixedRateJob() {
    System.out.println("Something to be done every 2 secs");
}

@Bean
public TaskScheduler poolScheduler() {
    return new CustomTaskScheduler();
}

class CustomTaskScheduler extends ThreadPoolTaskScheduler {

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, period);

        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        scheduledTasks.put(runnable.getTarget(), future);

        return future;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Date startTime, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, startTime, period);

        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        scheduledTasks.put(runnable.getTarget(), future);

        return future;
    }
}