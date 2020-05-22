class DbClientModule extends AbstractModule {
  @Override public void configure() {
    DbClient client = AnotherLibrary.createDbClient();
    bind(DbClient.class).toInstance(client);
  }
}