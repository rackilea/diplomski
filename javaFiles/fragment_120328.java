@Bean(name = "AsyncMccJobLauncher")
public JobLauncher simpleJobLauncher(JobRepository jobRepository) {
    SimpleJobLauncher jobLauncher = new SimpleJobLauncher() {
        @Override
        public JobExecution run(Job job, JobParameters jobParameters) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
            JobExecution jobExecution = super.run(job, jobParameters);
            // jobExecution is created and accessible here
            //MDC.put("execId", String.valueOf(jobExecution.getJobId()));
            //MDC.put("jobName", jobExecution.getJobInstance().getJobName());
            return jobExecution;
        }
    };
    jobLauncher.setJobRepository(jobRepository);
    SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
    jobLauncher.setTaskExecutor(taskExecutor);
    return jobLauncher;
}