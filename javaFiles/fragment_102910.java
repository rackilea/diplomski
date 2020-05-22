interface Handler {
  void foo();
}

public class BaseClass {

  private final Handler handler; // constructor omitted

  public void bar() {
    handler.foo();
  }
}