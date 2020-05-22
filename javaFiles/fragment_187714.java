public class MyDelegation {
  @RuntimeType
  public static Object intercept(@SuperCall Callable<?> superCall) throws Exception {
    // to do some work
    Object o = superCall.call();
    // to do some work
    return o;
  }
}