public static BasicCookieStore getCookieStore(String cookies, String domain) {
    String[] cookieValues = cookies.split(";");
    BasicCookieStore cs = new BasicCookieStore();

    BasicClientCookie cookie;
    for (int i = 0; i < cookieValues.length; i++) {
        String[] split = cookieValues[i].split("=");
        if (split.length == 2)
            cookie = new BasicClientCookie(split[0], split[1]);
        else
            cookie = new BasicClientCookie(split[0], null);

        cookie.setDomain(domain);
        cs.addCookie(cookie);
    }
    return cs;
}

 String cookies = CookieManager.getInstance().getCookie(url);
 BasicCookieStore lCS = getCookieStore(cookies, MyApp.sDomain);

 HttpContext localContext = new BasicHttpContext();
 DefaultHttpClient httpclient = new DefaultHttpClient();
 httpclient.setCookieStore(lCS);
 localContext.setAttribute(ClientContext.COOKIE_STORE, lCS);
 ...