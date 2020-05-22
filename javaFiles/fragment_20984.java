public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
  return addDomHandler(handler, MouseOverEvent.getType());
}

public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
  return addDomHandler(handler, MouseOutEvent.getType());
}