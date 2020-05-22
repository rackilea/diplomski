public class InjectorHolder() {
  private InjectorHolder() {}  // Not instantiable

  private static Injector injector;

  public static void initializeInjector() {
    injector = Guice.createInjector(new AModule(), new BModule(), andSoOn());
  }

  public static Injector get() {
    return injector;
  }

  public static B getB() {
    return injector.getInstance(B.class);
  }
}