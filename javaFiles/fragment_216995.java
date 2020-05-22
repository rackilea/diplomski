JobParametersBuilder builder = new JobParametersBuilder();
builder.addLong("run.ts", System.currentTimeMillis());
JobParameters jobParameters = builder.toJobParameters();

Job job = jobLocator.getJob(jobName);
jobLauncher.run(job, jobParameters);