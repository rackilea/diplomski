public static final int PORT = 1443;
private MockHttpsServer mockServer;

@Before
public void initHttps() {
    mockServer = new MockHttpsServer(PORT);
    mockServer.respondTo(get("a-service/resource")).withBody(expectedResponse);
}