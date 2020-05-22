BasicCookieStore cookieStore = new BasicCookieStore();
    for (Entry<String, String> cookieEntry : cookies.entrySet()) {
        BasicClientCookie cookie = new BasicClientCookie(cookieEntry.getKey(), cookieEntry.getValue());
        cookie.setDomain(".example.com");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
    }


    HttpContext localContext = new BasicHttpContext();
    localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

    HttpPost httpPost = new HttpPost("http://website.com/submitAnswer");
    List<NameValuePair> params = new ArrayList<NameValuePair>(1);
    params.add(new BasicNameValuePair("answer", answer);
    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    httpClient.execute(httpPost, localContext);