@InjectMocks
App app;

@Mock
URL url;

@Mock
OutputStream outStream;

@Test
public void uploadToS3_should_return_true() throws Exception{
    // no need to create instance of App, it should be initialyzed fine with @InjectMocks annotation
    // define mocked behavior   
    HttpURLConnection connection = PowerMockito.mock(HttpURLConnection.class);
    // mock connection and out stream methods
    PowerMockito.when(url.openConnection()).thenReturn(connection);
    PowerMockito.whenNew(URL.class).withArguments(Matchers.anyString()).thenReturn(url);

    PowerMockito.when(connection.getOutputStream()).thenReturn(outStream);
    PowerMockito.when(connection.getResponseCode()).thenReturn(200);

    // call action
    app.uploadToS3("http://something.com", "{}");
}