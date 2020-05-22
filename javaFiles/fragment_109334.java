package com.example;

public class ExampleListener implements javax.servlet.ServletContextListener {

   public void contextInitialized(ServletContext context) {
      JobDetail job = JobBuilder.newJob(ExampleJob.class)
            .withIdentity("exampleJob", "group").build();
      // Trigger
      Trigger trigger = TriggerBuilder
            .newTrigger()
            .withIdentity("exampleTrigger", "group")
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(120).repeatForever())
            .build();
      // Scheduler
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

   }
}