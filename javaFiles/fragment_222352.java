DefaultHttpClient httpClient = new DefaultHttpClient(params);
String[] keyValueSets = CookieManager.getInstance().getCookie(URI_FOR_DOMAIN).split(";");
for(String cookie : keyValueSets)
{
    String[] keyValue = cookie.split("=");
    String key = keyValue[0];
    String value = "";
    if(keyValue.length>1) value = keyValue[1];
    httpClient.getCookieStore().addCookie(new BasicClientCookie(key, value));
}