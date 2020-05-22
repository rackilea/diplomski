public class MyMouseEventHandler implements MouseOverHandler, MouseOutHandler {
  public void onMouseOver(final MouseOverEvent moe) {
    Widget widget = (Widget) moe.getSource();
    widget.addStyleName("my-mouse-over");
  }

  public void onMouseOut(final MouseOutEvent moe) {
    Widget widget = (Widget) moe.getSource();
    widget.removeStyleName("my-mouse-over");
  }
}