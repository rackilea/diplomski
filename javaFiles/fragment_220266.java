Calendar calendar = Calendar.getInstance();
calendar.add(Calendar.DAY_OF_YEAR, 100);
Date date = calendar.getTime();

DefaultHttpClient httpClient = new DefaultHttpClient();
httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,CookiePolicy.BROWSER_COMPATIBILITY);
httpClient.setCookieStore(new BasicCookieStore());
BasicClientCookie cookie = new BasicClientCookie(YourCookieName, YourCookieValue);
cookie.setDomain(YourDomain);
cookie.setExpiryDate(date);
cookie.setPath("/");
httpClient.getCookieStore().addCookie(cookie);

....

httpClient.execute(yourHttpUriRequest);