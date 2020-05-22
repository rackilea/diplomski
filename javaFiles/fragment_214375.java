public class AFactory {

  public A newA() {
    A a = new A();
    B b = new B(a);
    return a;
  }

}