public class MyHurlStack extends HurlStack {
    @Override
    public HttpResponse performRequest(
            Request<?> request, Map<String, String> additionalHeaders)
            throws IOException, AuthFailureError {

        Map<String, String> headers = request.getHeaders();
        // put your global headers
        headers.put("Via", "netroid");
        headers.put("Accept-Charset", "UTF-8");
        headers.put("Origin", "http://netroid.cn/");

        return super.performRequest(request, additionalHeaders);
    }
}

public class MyHttpClientStack extends HttpClientStack {
    public MyHttpClientStack(HttpClient client) {
        super(client);
    }

    @Override
    protected void onPrepareRequest(HttpUriRequest request) throws IOException {
        // put your global headers
        request.setHeader("Via", "netroid");
        request.setHeader("Accept-Charset", "UTF-8");
        request.setHeader("Origin", "http://netroid.cn/");
        super.onPrepareRequest(request);
    }
}