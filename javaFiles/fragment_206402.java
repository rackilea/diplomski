public class MyJobReader extends AbstractItemReader {

    @Inject
    private JobContext jobContext;

    @Override
    public Integer readItem() throws Exception {

        Properties pros = BatchRuntime.getJobOperator().getParameters(jobContext.getExecutionId());