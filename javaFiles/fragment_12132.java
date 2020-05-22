@Bean
public SimpleJobLauncher simpleJobLauncher() {
    SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
    jobLauncher.setJobRepository(jobRepository);
    jobLauncher.setTaskExecutor(simpleAsyncTaskExecutor());
    return jobLauncher;
}

public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
    SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
    simpleAsyncTaskExecutor.setConcurrencyLimit(10);
    return simpleAsyncTaskExecutor;
}

@Bean
public JobOperator jobOperator() {
    SimpleJobOperator jobOperator = new SimpleJobOperator();
    jobOperator.setJobLauncher(simpleJobLauncher());
    jobOperator.setJobExplorer(jobExplorer);
    jobOperator.setJobRegistry(jobRegistry);
    jobOperator.setJobRepository(jobRepository);
    return  jobOperator;
};