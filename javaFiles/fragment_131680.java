abstract class AbstractObject {
   public abstract void method();
}

class ImplementingObject extends AbstractObject {
  public void method() {
    doSomething();
  }
}