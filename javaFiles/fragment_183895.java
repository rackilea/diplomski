public class MyModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new SourcePrivateModule(SourceDatabase.class, "database"));
    install(new SourcePrivateModule(SourceFileSystem.class, "file-system"));
  }
}