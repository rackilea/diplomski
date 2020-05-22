CloseableHttpClient httpclient = HttpClients.createDefault();
CookieStore cookieStore = new BasicCookieStore();

// Create local HTTP context
HttpClientContext localContext = HttpClientContext.create();
// Bind custom cookie store to the local context
localContext.setCookieStore(cookieStore);

HttpGet httpget = new HttpGet("http://httpbin.org/cookies");
System.out.println("Executing request " + httpget.getRequestLine());

// Pass local context as a parameter
CloseableHttpResponse response = httpclient.execute(httpget, localContext);
try {
    System.out.println("----------------------------------------");
    System.out.println(response.getStatusLine());
    List<Cookie> cookies = cookieStore.getCookies();
    for (int i = 0; i < cookies.size(); i++) {
        System.out.println("Local cookie: " + cookies.get(i));
    }
    EntityUtils.consume(response.getEntity());
} finally {
    response.close();
}