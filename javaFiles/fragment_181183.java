public class BatchProducerBean {
...
@Produces
@Dependent
public JobContext getJobContext() {
    ...
        return JobContextImpl;
    }
}