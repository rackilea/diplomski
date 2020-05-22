public class CustomHttpClientFactory extends HttpClientConfig.HttpClientFactory {
    @Override
    public HttpClient createHttpClient() {
        DefaultHttpClient client = new DefaultHttpClient();
        client.addRequestInterceptor((request, ctx) -> {
            // do what you will 
        });
        client.addResponseInterceptor((response, ctx) -> {
            // do what you will
        });
        return client;
    }
}