VerticalPanel panel =//;
panel.addDomHandler(new KeyUpHandler() {
  @Override
  public void onKeyUp(KeyUpEvent event) {
    switch (event.getNativeKeyCode()) {
    case KeyCodes.KEY_LEFT:
      //...
    case KeyCodes.KEY_RIGHT:
    }
  }
}, KeyUpEvent.getType());