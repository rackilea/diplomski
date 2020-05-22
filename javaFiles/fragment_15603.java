public class MyClass<T> {
  // ...

  public MyClass() { ... }

  public <U> MyClass<U> cast() {
    MyClass<U> copy = new MyClass<>();
    return copy.withFoo(foo).withBar(bar);
  }

  public MyClass<T> withFoo(int foo) { ... }
  public MyClass<T> withBar(String bar) { ... }
}