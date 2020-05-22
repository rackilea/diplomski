public static void main(String[] args) {
  DbClient client = SomeWeirdPlace.getDbClient();
  Injector injector = Guice.createInject(new MyModule(client));
  injector.getInstance(ServerInterface.class).start();
}

class MyModule extends AbstractModule {
  MyModule(DbClient client) {
    this.client = client;
  }
  @Override public void configure() {
    bind(Client.class).toInstance(client);
  }
}