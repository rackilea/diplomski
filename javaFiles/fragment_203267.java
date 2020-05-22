public class InjectionPointGenerator {

  @Inject
  private InjectionPoint injectionPoint;

  public InjectionPoint getInjectionPoint() {
    return injectionPoint;
  }
}


public class BeanUtils {

  protected BeanUtils() {
    // Prevent instantiation
  }

  public static InjectionPoint getInjectionPoint(@Nonnull CreationalContext context) {
    Bean<InjectionPointGenerator> bean = getBean(InjectionPointGenerator.class);
    BeanManager beanManager = BeanManagerProvider.getInstance().getBeanManager();
    InjectionPoint injectionPoint = bean.getInjectionPoints().iterator().next();
    return (InjectionPoint) beanManager.getInjectableReference(injectionPoint, context);
  }

  private static <T> Bean<T> getBean(@Nonnull Class<T> type) {
    return BeanProvider.getBeanDefinitions(type, false, true).iterator().next();
  }
}