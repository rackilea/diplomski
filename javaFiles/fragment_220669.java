public class StaticBModule extends AbstractModule() {
  @Override public void configure() { requestStaticInjection(BFactory.class); }
}

public class BFactory() {
  @Inject @Named("B") private static Provider<B> bProvider;

  public B get() {
    return bProvider.get();
  }
}