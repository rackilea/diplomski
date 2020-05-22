@Bean
  public SpringDataSourceBeanPostProcessor monitoringDataSourceBeanPostProcessor() {
    SpringDataSourceBeanPostProcessor processor = new SpringDataSourceBeanPostProcessor();
    processor.setExcludedDatasources(null);
    return processor;
  }