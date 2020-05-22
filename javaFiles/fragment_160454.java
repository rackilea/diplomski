public class ProviderFactory {

  public static create(Lifecycle lc) {
    return new Provider(lc, new PropertySetter(lc));
  }
}