public class DoSomethingAroundJob implements JobExecutionListener {

  public void beforeJob(JobExecution jobExecution) {
      System.out.println("Called beforeJob().");
  }

  public void afterJob(JobExecution jobExecution) {
      System.out.println("Called afterJob().");
  }
}