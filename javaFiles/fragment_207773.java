public class UsesExternalResource {
  public Server myServer= new Server();

  @BeforeClass
  public void before() {
    myServer.connect();
  }

  @AfterClass
  public void before() {
    myServer.disconnect();
  }
}