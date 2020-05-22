@Service
public class SpringContext implements ApplicationContextAware {
  private static ApplicationContext context;

  public void setApplicationContext(ApplicationContext context) throws BeansException {
    this.context = context;
  }

public static <T> T getProxy (Class<T> proxyClass){
    return (T) context.getBean(proxyClass);
  }
}