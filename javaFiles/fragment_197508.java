@Test
public void testBid() throws IOException {
    //given:
    HttpGet httpGet = mock(HttpGet.class);
    HttpResponse httpResponse = mock(HttpResponse.class);

    StatusLine statusLine = mock(StatusLine.class);

    ObserverImp observer = mock(ObserverImp.class);

    CloseableHttpClient closeableHttpClient = mock(CloseableHttpClient.class);
    CloseableHttpResponse closeableHttpResponse = mock(CloseableHttpResponse.class);

    //and:
    when(statusLine.getStatusCode()).thenReturn(200);
    when(httpResponse.getStatusLine()).thenReturn(statusLine);
    when(closeableHttpClient.execute(httpGet)).thenReturn(closeableHttpResponse);
    when(observer.getKey()).thenReturn("##213");


    Buy buy = new Buy(observer, closeableHttpClient);
    buy.bid(14455);
}