public class YourInjectableClass {
  @Inject private Injector injector;
  public void doStuff(String key) {
    // You need an OuterObject. So rather than calling
    // new OuterObject(new InnerObject(factory.getMyService(key))), do:
    OuterObject outerObject =
        injector.createChildInjector(new OuterObjectModule(key))
        .getInstance(OuterObject.class);
    // [...]
  }
}