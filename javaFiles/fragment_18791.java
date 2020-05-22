public String logout(Context context)
        throws MalformedURLException, IOException {
    Util.clearCookies(context);
    Bundle b = new Bundle();
    b.putString("method", "auth.expireSession");
    String response = request(b);
    setAccessToken(null);
    setAccessExpires(0);
    return response;
}`