interface HappyHandler extends EventHandler {
  public void onHappiness(HappyEvent event);
}

interface HasHappyEvents {
  public HandlerRegistration addHappyHandler(HappyHandler handler);
}