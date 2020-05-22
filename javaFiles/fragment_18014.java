public class SystemUnderTest {

    private HttpClientFactory httpClientFactory;

    public SystemUnderTest(HttpClientFactory httpClientFactory) {
        this.httpClientFactory = httpClientFactory;
    }

    HttpResponse postRequest(String url, String request) {
        HttpResponse resp = null;
        try {
            HttpClient client = httpClientFactory.create();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type", "application/x-www-form-urlencoded");
            post.setEntity(new StringEntity(request));

            resp = client.execute(post);
            return resp;
        } catch (Exception e) {
            return null;
        }
    }
}