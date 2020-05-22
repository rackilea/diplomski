public class Base {
  @Async
  public void foo() {
  }
}
public class Child extends Base {
  // Trivial implementation needed only to make the annotation available here. 
  @Async
  public void foo() {
      super.foo();
  }
}