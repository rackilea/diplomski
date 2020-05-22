public class ItemReadCountListener implements ItemReadListener<T>, StepExecutionListener {

    private Integer count = 0;

    @Override
    public void afterRead(T item) {
        count++; // Increment counter
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
       stepExecution.getJobExecution().getExecutionContext().put("ITEM_READ_COUNT", count); // Store counter
    }
}