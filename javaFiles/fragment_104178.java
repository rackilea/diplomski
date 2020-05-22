HttpClient httpClient = new DefaultHttpClient();
CookieStore cookieStore = new BasicCookieStore();
HttpContext httpContext = new BasicHttpContext();
httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
// ...

HttpResponse response1 = httpClient.execute(method1, httpContext);
// ...

HttpResponse response2 = httpClient.execute(method2, httpContext);
// ...