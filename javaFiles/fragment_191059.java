public class MyLineMapper<T> implements LineMapper<T>, InitializingBean, StepExecutionContext {
  ExecutionContext stepExecution;

  public void beforeStep(ExecutionContext stepExecution) { this.stepExecution = stepExecution;}

  public T mapLine(String line, int lineNumber) throws Exception {
    this.stepExecution.putInt("name", lineNumber);
    // rest of your code..
  }
}