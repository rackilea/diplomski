public class Foo {
  @Subscribe
  public void handleEvent(String eventId) {
    // do something
  }
}

Foo foo = ...
eventBus.register(foo);
eventBus.post(eventId);