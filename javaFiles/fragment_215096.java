import static MyLogger.*;

public class Foo {
  public void bar() {
    // makes use of static import!
    debug("Method bar() was just called"); 
    debug(this.getClass(), "Method bar() was just called"); 
  }
}