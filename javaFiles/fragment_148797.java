import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("BatchletName")
public class BatchletName extends AbstractBatchlet {
    @Inject
    JobContext jobContext;

    public String process() throws Exception {
        // I need jobId here

        String jobId = jobContext.getJobName();
        return "";
    }  
}