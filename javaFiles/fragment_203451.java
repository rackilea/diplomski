public class A<T> {
  private Class<T> clazz;

  public A(Class<T> clazz) {
    this.clazz = clazz;
  }

  public T genericInstance() {
    T target = null;
    try {
      // Class<T> clazz = getGenericClass();
      target = clazz.newInstance();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    return target;
  }
}