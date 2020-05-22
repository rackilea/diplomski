public class YourInjectableClass {
  @Inject private MyFactory factory;

  public void doStuff(String key) {
    // You have a key, and your factory, so you can create the instance yourself.
    SomeService service = factory.getMyService(key);
    // [...]
  }
}