public class MyInjector extends AbstractModule {
  private final Map<String,String> mapProps;
  public MyInjector(Map<String,String> mapProps) {
    this.mapProps = mapProps;
  }
  protected void configure() {
    bind(Config.class).to(ConfigImpl.class).in(Scope.SINGLETON);         // You most than likely want this
    bind(new TypeLiteral<Map<String,String>>() {}).toInstance(mapProps); // binding for the map.
  }
}