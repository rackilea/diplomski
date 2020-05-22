public class Main {
  public static void main(String[] args) throws Exception {
    Class<? extends MyService> serviceClass = new ByteBuddy()
      .subclass(MyService.class)
      .method(ElementMatchers.named("sayFoo").or(ElementMatchers.named("sayBar")))
      .intercept(MethodDelegation.to(MyServiceInterceptor.class))
      .make()
      .load(Main.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
      .getLoaded();

    MyService service = serviceClass.newInstance();

    service.sayFoo();
    service.sayBar();
  }
}