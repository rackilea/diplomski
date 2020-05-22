class YourMainModule() {
  public static void main(String[] args) {
    MyAppConfig config = createAppConfig(); // define this yourself

    Injector injector = Guice.createInjector(
        new ConfigModule(config),
        new YourOtherModule(),
        new YetAnotherModule());

    injector.getInstance(YourApplication.class).run();
  }
}

class ConfigModule extends AbstractModule {
  private final MyAppConfig config;

  ConfigModule(MyAppConfig config) {
    this.config = config;
  }

  @Override public void configure() {
    // Because you're binding to a single instance, you always get the
    // exact same one back from Guice. This makes it implicitly a singleton.
    bind(MyAppConfig.class).toInstance(config);
  }
}