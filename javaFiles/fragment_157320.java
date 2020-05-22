@Bean
@StepScope
  public PartitionHandler masterSlaveHandler(@Value("#{stepExecutionContext[gridSize]}") int gridSize) {
    TaskExecutorPartitionHandler handler = new TaskExecutorPartitionHandler();
    handler.setGridSize(gridSize);
    handler.setTaskExecutor(taskExecutor());
    handler.setStep(slave());
    try {
      handler.afterPropertiesSet();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return handler;
  }