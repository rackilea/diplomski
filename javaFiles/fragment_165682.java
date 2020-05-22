@RunWith(PowerMockRunner.class)
@PrepareForTest({Jsoup.class})
public class MyClassTest {

    @Test(expected = SiteBusinessException.class)
    public void shouldThrowIOException() throws Exception {
        String SITE_URL = "some_url_string";

        Connection connection = Mockito.mock(Connection.class);
        Mockito.when(connection.execute()).thenThrow(new IOException("test"));
        PowerMockito.mockStatic(Jsoup.class);

        PowerMockito.when(Jsoup.connect(Mockito.anyString())).
            thenReturn(connection);

        AnalyzerService sut = new AnalyzerService();
        sut.analyze(SITE_URL);
    }
}