@Test
public void someTest() throws IOException {
    HttpURLConnection connection = Mockito.mock(HttpURLConnection.class);
    String instance = "...";
    String reqId = "...";

    DemoRestClient demoRestClient = new DemoRestClient(instance, reqId, connection);

    // in case you need to mock a response from the conneciton
    Mockito.when(connection.getInputStream()).thenReturn(...);

    demoRestClient.run();

    // in case you want to verify invocations on the connection
    Mockito.verify(connection).setRequestMethod("GET");
}