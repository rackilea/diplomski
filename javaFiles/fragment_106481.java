final JobDataMap jobDataMap = new JobDataMap();
jobDataMap.put(MY_INTERFACE, myInterface);

final Job myJob =
    JobBuilder.newJob(MyJob.class)
              .setJobData(jobDataMap)
              .build();