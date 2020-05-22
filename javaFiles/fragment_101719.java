@Configuration
class StaticApplicationContext implements ApplicationContextAware{

  static ApplicationContext applicationContext = null;

  public void setApplicationContext(ApplicationContext context)    throws BeansException {
    applicationContext = context;
  }
  /**
   * Note that this is a static method which expose ApplicationContext
   **/
  public static ApplicationContext getContext(){
        return applicationContext;
  }

}