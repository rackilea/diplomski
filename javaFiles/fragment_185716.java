public class MyHandler implements InvocationHandler {
  private final Object o;

  public MyHandler(Object o) {
    this.o = o;
  }

  public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    Method method = o.getClass().getMethod(m.getName(), m.getParameterTypes());
    return method.invoke(o, args);
  }
}