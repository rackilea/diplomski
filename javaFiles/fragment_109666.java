public class SchedulerConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(4); // Number of simultaneously running @Scheduled functions
        taskScheduler.initialize();
        taskRegistrar.setTaskScheduler(taskScheduler);
    }