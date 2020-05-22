@Test
public void testServiceValidHost() throws ClientProtocolException, IOException {
    //Arrange
    HealthService service = new HealthService();
    HealthService spy = Mockito.spy(service);

    //You have to use doReturn() for stubbing
    doReturn(SOMESTATUS).when(spy).getHTTPResponse("http://" + HOST + "/health");

    //Act
    String actual = spy.executeHealthCheck(HOST);

    //Assert
    assertEquals(SOMESTATUS, actual);
}