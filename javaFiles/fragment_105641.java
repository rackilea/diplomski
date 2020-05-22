@Component
public class SingleInstanceListener implements JobExecutionListener {
    @Autowired
    private JobExplorer explorer;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        Set<JobExecution> executions = explorer.findRunningJobExecutions(jobName);
        if(executions.size() > 1) {
            jobExecution.stop();
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }

}