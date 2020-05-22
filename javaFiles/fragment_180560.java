import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MainJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext)
      throws JobExecutionException {

        // Simulate job execution for 5 seconds...
        try {
            System.out.println("Executing job in background...");
            Thread.sleep(1000 * 5 /* secs */);
            System.out.println("Done executing job.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}