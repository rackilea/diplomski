@ClassRule
public static ExternalResource resource = new ExternalResource() {
  @Override
  protected void before() throws Throwable {
    myServer.connect();
  }

  @Override
  protected void after() {
    myServer.disconnect();
  }
};