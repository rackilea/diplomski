/** Annotates a configuration value. */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
  String value();
}

/** Installs bindings for {@link MyConfiguration}. */
final class MyConfigurationModule extends AbstractModule {
  @Override protected void configure() {}

  @Provides
  @Singleton
  MyConfiguration provideMyConfiguration() {
    // read MyConfiguration from disk or somewhere
  }

  @Provides
  @Config("x")
  String provideX(MyConfiguration config) {
    return config.getConfig("x").getName();
  }
}

// elsewhere:

/** The main application. */
final class MyApplication {
  private final String xConfig;

  @Inject MyApplication(@Config("x") String xConfig) {
    this.xConfig = xConfig;
  }

  // ...
}