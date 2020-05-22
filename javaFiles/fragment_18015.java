@Test
public void testPostRequest() throws Exception {
    // Arrange
    HttpResponse expected = mock(HttpResponse.class);
    HttpClient httpClient = mock(HttpClient.class);
    when(httpClient.execute(any())).thenReturn(expected);

    HttpClientFactory httpClientFactory = mock(HttpClientFactory.class);
    when(httpClientFactory.create()).thenReturn(httpClient);

    SystemUnderTest systemUnderTest = new SystemUnderTest(httpClientFactory);

    String url = "http://url_here";
    String request = "Hello World";

    // Act
    HttpResponse actual = systemUnderTest.postRequest(url, request);

    // Assert
    assertEquals(expected, actual);
    //should also verify that the expected arguments as passed to execute()
}