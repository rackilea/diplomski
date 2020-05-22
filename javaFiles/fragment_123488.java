@Component
public class MyWriter implements ItemWriter<MyBean> {

    private JobExecution jobExecution;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        jobExecution = stepExecution.getJobExecution();
    }

    @Override
    public void write(@NonNull List<? extends MyBean> items) throws Exception {
        MyResult result = someComponent.doSmth(items);
        jobExecution.getExecutionContext().put("result", result); // not sure how you are planning to use a map here
    }
}