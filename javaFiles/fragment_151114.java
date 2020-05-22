@Configuration
@EnableScheduling
public class Schedule implements SchedulingConfigurer {

@Override
public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(taskScheduler());
    taskRegistrar.addTriggerTask(
            myTask(), new ExponentialTrigger()
    );
}

static class ExponentialTrigger implements Trigger {

    long n = 0;

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        // delay from last scheduled time or completion time? pick yours 
        Date lastDate = triggerContext.lastScheduledExecutionTime(); 
        long last;
        if (lastDate == null) {
            last = System.currentTimeMillis();
        } else {
            last = lastDate.getTime();
        }

        return new Date(last + ((int) Math.pow(10, n++)) * 60_000); // * 60_000 millis to minutes
    }
}


@Bean(destroyMethod = "shutdown")
public ExecutorService taskScheduler() {
    return Executors.newScheduledThreadPool(42); // if you have single task, which is faster than delay then this can be 1
}

@Bean
public Runnable myTask() {
    return new Runnable() {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    };
}