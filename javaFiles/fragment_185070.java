@Bean
    public ThreadPoolTaskExecutor threadPool() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(5);
        pool.setMaxPoolSize(10);
        pool.setQueueCapacity(25);
        return pool; 
    }

  @Bean
  public TaskExecutorExample executorExample() {
    return new TaskExecutorExample(threadPool());
  }