public class Foo<T, F extends Foo<T, F>> {
  public F someMethod() {
    System.out.println("foo");
    return (F) this; // <--- That's the unchecked cast! Tucked safely away.
  }
  public static void main(String[] args) {
    new Bar<String>().someMethod().barMethod();
  }
}

class Bar<T> extends Foo<T, Bar<T>> {
  public Bar<T> barMethod() {
    System.out.println("bar");
    return this;
  }
}