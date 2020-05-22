public class MyClass {
  public interface SuperInterface<T>{}

  public interface MyInterface extends SuperInterface<MyClass> {}

  public class Worker<U extends MyClass, T extends SuperInterface<U>> {}

  public void compileTest() {
    // just to make sure the declaration compiles
    Worker<MyClass, MyInterface> worker = null;
  }
}