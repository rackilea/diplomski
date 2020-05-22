public abstract class ControllerBase extends Controller {
  static void foo() {
    // this actually gets called
  }
}

public static class ConcreteController extends Controller {
  @Before
  static void bar() {
    foo();
    // This DOES NOT get called
  }

  public static void index() {
    render();
  }
}