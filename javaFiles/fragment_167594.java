public class MyWidget extends Widget implements HasMyHandlers {

  @Override
  public HandlerRegistration addMyHandler(MyHandler handler) { 
    return addHandler(handler, MyEvent.getType());
  }

  // Other methods
}