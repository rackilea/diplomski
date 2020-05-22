interface DbClient {
}

@Singleton
class DbClientImpl implements DbClient {
}

class DbClientModule extends AbstractModule {
  @Override public void configure() {
    bind(DbClient.class).to(DbClientImpl.class);
  }
}