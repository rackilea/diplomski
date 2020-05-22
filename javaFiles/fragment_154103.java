@Component("BeanA")
public class MyClass implements MyInterface {
  private MyInterface target;

  public void setTarget(MyInterface target) {
    this.target = target;
  }

  // now delegating implementation of MyInterface methods
  public void method1(..) {
    this.target.method1(..);
  }

  ..
}