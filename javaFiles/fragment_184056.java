public class Factory {

  public static Widget buildWidget() {
    Widget widget = new Widget();
    return widget;
  }

  public class Widget {
    private Widget() { ... }
    public void someMethod() { ... }
  }
}