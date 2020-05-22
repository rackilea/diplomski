@Bean
@Qualifier(value = "executorOne")
public Executor getAsyncExecutor() {
//..
  return executor;
}