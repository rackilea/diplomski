List<Cookie> cookies = httpClient.getCookieStore().getCookies();

if(cookies != null)
{
    for(Cookie cookie : cookies)
    {
        String cookieString = cookie.getName() + "=" + cookie.getValue() + "; domain=" + cookie.getDomain();                        
        CookieManager.getInstance().setCookie(cookie.getDomain(), cookieString);  
    }
}
CookieSyncManager.getInstance().sync();