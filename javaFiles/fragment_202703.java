@Test(expected=UnsupportedOperationException.class)
public void test() {
    HttpClient httpClient = mock(HttpClient.class);
    PowerMockito.whenNew(HttpClient.class).withNoArguments().thenReturn(httpClient);
    when(httpClient.executeMethod(any(HttpMethod.class))).thenThrow(UnsupportedOperationException.class);

    new PowerMockitoProduction().createClient();
    verify(httpClient).executeMethod(null);
}