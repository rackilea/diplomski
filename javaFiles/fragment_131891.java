public InputStream processPostRequest(String requestUrl) {

    DefaultHttpClient client = null;

    client = createHttpClient("admin", "pas");

    HttpEntity entity = null;

    BasicHttpContext context = null;
    context = createHttpContext();

    client.addRequestInterceptor(new HttpRequestInterceptor(), 0);
    HttpGet get = new HttpGet(requestUrl);

    try {

        // Execute your request with the given context
        HttpResponse response = client.execute(get, context);
        entity = response.getEntity();

    } catch (IOException e) {
        e.printStackTrace();
    }

    return entity..getContent();
}