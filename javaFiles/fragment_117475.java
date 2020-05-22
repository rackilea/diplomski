public class Bar extends Foo {
  protected Object doGetX() {
    return getX();
  }
  public int process(){
    Object value = doGetX();
    ...
  }
}