new FlatFileItemReader<String>() {
  @BeforeStep
  public void before(StepExecution stepEx) {
       //this will never be called! don't do this.
  }
};