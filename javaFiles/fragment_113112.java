@Test
public void testServiceValidHost() throws ClientProtocolException, IOException {
    //Arrange    
    HealthService service = Mockito.mock(HealthService.class);

    when(service.executeHealthCheck(HOST)).callRealMethod();
    when(service.getHTTPResponse("http://" + HOST + "/health")).thenReturn(SOMESTATUS);

    //Act
    String actual = service.executeHealthCheck(HOST);

    //Assert
    assertEquals(SOMESTATUS, actual);
}