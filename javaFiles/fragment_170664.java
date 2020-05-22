class HappyEvent extends GwtEvent {
  static Key<HappyEvent,HappyHandler> KEY = new Key<HappyEvent,HappyHandler>(){
    protected void fire(HappyHandler handler, HappyEvent event) {
       handler.onHappiness(event);
    };
   ...
}