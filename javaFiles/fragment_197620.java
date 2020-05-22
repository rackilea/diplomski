CookieStore cookieStore = new BasicCookieStore();
//cookieStore.addCookie();
Executor executor = Executor.newInstance();
executor.cookieStore(cookieStore)
        .execute(Request.Get("/stuff"))
        .returnContent();