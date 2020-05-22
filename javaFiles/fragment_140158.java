public class MyClass<T> {
  private Class<T> cl ;
  public MyClass(Class<T> cl) {
    this.cl = cl ;
    ...
  }
  public boolean equal(T value) {
    return true;
  }
}