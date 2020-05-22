@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    // do your stuff here 
  }
}