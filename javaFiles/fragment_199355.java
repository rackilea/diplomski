HttpClient httpclient = new DefaultHttpClient();

    // Create a local instance of cookie store
    CookieStore cookieStore = new BasicCookieStore();

    // Create local HTTP context
    HttpContext localContext = new BasicHttpContext();
    // Bind custom cookie store to the local context
    localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

    HttpGet httpget = new HttpGet("http://www.google.com/", localContext);