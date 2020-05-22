@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.crypto.*")
@PrepareForTest({ HttpPost.class, DefaultHttpClient.class, A.class })
public class TestA {

    @Test
    public void testA() throws Exception {
        HttpPost httpPost = Mockito.mock(HttpPost.class);
        PowerMockito.whenNew(HttpPost.class).withArguments(oAuthMessage.URL).thenReturn(httpPost);

        DefaultHttpClient defaultHttpClientMock = PowerMockito.mock(DefaultHttpClient.class);
        HttpResponse httpResponse = PowerMockito.mock(HttpResponse.class);
        PowerMockito.whenNew(DefaultHttpClient.class).withNoArguments().thenReturn(defaultHttpClientMock);

        PowerMockito.when(defaultHttpClientMock.execute(httpPost)).thenReturn(httpResponse);

        StatusLine statusLine = PowerMockito.mock(StatusLine.class);

        PowerMockito.when(httpResponse.getStatusLine()).thenReturn(statusLine);
        Integer expected = new Integer(0);
        PowerMockito.when(statusLine.getStatusCode()).thenReturn(expected);

        A a = new A();
        Assert.assertEquals(expected, a.callMethod());
    }
}