CookieManager cookieManager = new CookieManager();
    CookieHandler.setDefault(cookieManager);

    HttpCookie cookie = new HttpCookie("lang", "fr");
    cookie.setDomain("twitter.com");
    cookie.setPath("/");
    cookie.setVersion(0);
    cookieManager.getCookieStore().add(new URI("http://twitter.com/"), cookie);