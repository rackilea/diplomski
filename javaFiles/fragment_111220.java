public class MyServiceInterceptor {
  @RuntimeType
  public static Object intercept(@SuperCall Callable<?> zuper) throws Exception {
    return zuper.call();
  }
}