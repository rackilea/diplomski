CookieManger cookieManager = MyAuthentication.mCookieManager;

//authentication code
//...
if(mCookieManager.getCookieStore().getCookies().size() > 0) {
    urlConnection.setRequestProperty("Cookie",
    TextUtils.join(";", mCookieManager.getCookieStore().getCookies()));
}