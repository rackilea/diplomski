public class SpringApplicationContextProvider implements ApplicationContextAware {
  public void setApplicationContext(ApplicationContext ctx)
        throws BeansException {
      // Wiring the ApplicationContext into a static method
      SpringApplicationContext.setApplicationContext(ctx);
  }
}