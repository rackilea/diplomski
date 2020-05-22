private NioServer server;
@BeforeClass
public void beforeClass() {
    server = getServer();
    server.run();
}

@Test
public void testOne() {
    sendSomeDataToServer("data");
    assertEquals("data", server.getLastReceivedData());
}