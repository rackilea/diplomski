public class SingletonSetCoefProviders {
  private static SetCoefProvider obj1Provider, obj2Provider;

  static {
    obj1Provider = SetCoefProviderFactory.createObj1Provider();
    obj2Provider = SetCoefProviderFactory.createObj2Provider();
  }

  public static SetCoefProvider getObj1Provider() {
    return obj1Provider;
  }
  public static SetCoefProvider getObj2Provider() {
    return obj2Provider;
  }
}