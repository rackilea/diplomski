public abstract class EventSubscriber<T extends Event> {

  @Subscribe
  public void invoke(T event) {
    try {
      handle(event);
    } catch (Exception e) {
      Set thread local variable to e
    }
  }

  protected abstract void handle(T event);

}