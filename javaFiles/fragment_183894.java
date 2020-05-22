public class MyModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new PrivateModule() {
      @Override public void configure() {
        // Bind Source to SourceDatabase.
        bind(Source.class).to(SourceDatabase.class);
        // Bind @Named("database") Service to Service.
        bind(Service.class).annotatedWith(Names.named("database"))
            .to(Service.class);
        // Now expose @Named("database") Service without exposing
        // either of the other two conflicting bindings.
        expose(Service.class).annotatedWith(Names.named("database"));
      }
    });
    install(new PrivateModule() {
      @Override public void configure() {
        // Same as above.
        bind(Source.class).to(SourceFileSystem.class);
        bind(Service.class).annotatedWith(Names.named("file-system"))
            .to(Service.class);
        expose(Service.class).annotatedWith(Names.named("file-system"));
      }
    });
  }
}