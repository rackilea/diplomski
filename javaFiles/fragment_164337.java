class B extends AbstractModule {
    protected void configure() {
    }
}

public class A extends B {
  Injector injector;

  @Override
  protected void configure() {
    injector = Guice.createInjector(this);
  }
}

public class GuiceTest {
  public static void main(String... args) {
    A a = new A();
    Injector inj = Guice.createInjector(a);
  }
}