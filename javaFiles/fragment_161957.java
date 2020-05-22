public class MyApplicationGinModule
  extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(MyClass.class).toProvider(MyClassProvider.class)
                       .in(Singleton.class);
  }
}