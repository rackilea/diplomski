public class HttpClientTest {

    private JSONParser jsonParser = new JSONParser();

    @Test
    public void readJsonDataFromUrlSucceeds() throws IOException, ParseException {
        HttpClient httpClient = new HttpClientMock();

        String jsonString = httpClient.readJsonDataFromUrl();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonString);

        assertTrue(jsonObject.size() > 0);
    }

    @Test(expected = IOException.class)
    public void readJsonDataFromMalformedUrlFails() throws IOException, ParseException {
        HttpClient httpClient = new HttpClientMock("http://malformed");

        httpClient.readJsonDataFromUrl();
    }
}