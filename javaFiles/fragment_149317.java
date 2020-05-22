JobDetail job = newJob(MyJob.class)
         .withIdentity("myJob")
         .build();

     Trigger trigger = newTrigger() 
         .withIdentity(triggerKey("myTrigger", "myTriggerGroup"))
         .withSchedule(simpleSchedule()
             .withIntervalInHours(1)
             .repeatForever())
         .startAt(futureDate(10, MINUTES))
         .build();

     scheduler.scheduleJob(job, trigger);