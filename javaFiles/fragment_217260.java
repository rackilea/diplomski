public class SchedularJob implements Job {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        if (checkDateTime()) {
            System.out.println("Skip the job");
        }else{
           System.out.println(" : Job Executed..!!"); // execute your Job.
        }                     

    }

}