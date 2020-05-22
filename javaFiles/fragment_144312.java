@Configuration
public class SchedulingConfigurerConfiguration implements SchedulingConfigurer {

@Override
public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
     ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
     taskScheduler.setPoolSize(100);
     taskScheduler.initialize();
     taskRegistrar.setTaskScheduler(taskScheduler);
   }
 }