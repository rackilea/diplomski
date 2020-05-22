public class Parent<T> {

  public T example() {
    System.out.println(this.getClass().getCanonicalName());
    return (T)this;
  }
}