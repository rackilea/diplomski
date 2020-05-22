package mycompany;
public class MyRefreshTask extends QuartzJobBean {
    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("MyRefreshTask executing" );
    }
}