JobDetail jobDetail = JobBuilder.newJob()
    .ofType(DataMapJob.class)
    .withIdentity("dataJob", "dataJobGroup")
    .storeDurably(true)
    .requestRecovery(true)
    .build();