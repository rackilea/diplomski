@Service
public class MyService implements ApplicationListener<ContextRefreshedEvent> {

  public void onApplicationEvent(ContextRefreshedEvent event) {
    // This method will be executed at context startup or refresh
    // It is guaranteed all beans have finish constructing, hence
    // AOP tx is available
  }
  ...
}