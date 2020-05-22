public class MyClassProvider
  implements Provider<MyClass> {

  static MyClass myClass = new MyClass();

  @Override
  public MyClass get() {
    return MyClass;
  }
}