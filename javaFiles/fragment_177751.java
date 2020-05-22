import org.quartz.*;

@PersistJobDataAfterExecution
public class ExampleJob {

    static triggers = {
        simple repeatInterval: 1000l // execute job every 1 second
    }

    @Override
    void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.jobDetails.jobDataMap
        Integer count = jobDataMap.get("count") ?: 0    
        jobDataMap.put("count", ++count)
    }
}