public class Module extends AbstractModule {

  @Override
  protected void configure() {
    ...
    bind(JestClient.class).toInstance(jestFactory.getObject());
    ...
  }
}