//In MyAuthentication class
static CookieManager mCookieManager = new CookieManager();
static String COOKIE_HEADER = "Set-Cookie";

//authentication code 
//...

int responseCode = urlConnection.getResponseCode();
if(responseCode == HttpURLConnection.HTTP_OK){                
    Map<String, List<String>> headers = urlConnection.getHeaderFields();
    List<String> cookies = headers.get(COOKIE_HEADER);

    for(String cookie: cookies){
        HttpCookie httpCookie = HttpCookie.parse(cookie).get(0);
        mCookieManager.getCookieStore().add(null, httpCookie);
    }
}