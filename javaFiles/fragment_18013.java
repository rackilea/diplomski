public class HttpClientFactoryImpl implements HttpClientFactory {

    //...

    public HttpClient create() {
        return HttpClientBuilder.create().useSystemProperties().build();
    }

    //...
}