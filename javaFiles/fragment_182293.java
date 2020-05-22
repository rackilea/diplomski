public class StaticInjectionExample {

  static class SomeClass {}

  static class TagLib{
    @Inject
    static SomeClass injected;

    public static void taglibFunction(String foo) {
      injected.something(foo);
    }

  }

  static class TestModule extends AbstractModule {
    @Override
    protected void configure() {
      requestStaticInjection(TabLib.class);
    }
  }

  @Test
  public void test() {
    Injector injector = Guice.createInjector(new TestModule());
    TagLib receiver = injector.getInstance(TagLib.class);
    // Do something with receiver.injected
  }
}