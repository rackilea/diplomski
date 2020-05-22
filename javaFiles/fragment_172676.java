@Bean
public ApplicationListener<ContextRefreshedEvent> applicationListener() {
  return new ApplicationListener<ContextRefreshedEvent>() {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      // Do nothing
    }   
  };
}