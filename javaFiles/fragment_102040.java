class LenientCookieSpec extends BrowserCompatSpec {
    public LenientCookieSpec() {
        super();
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(DATE_PATTERNS) {
            @Override public void parse(SetCookie cookie, String value) throws MalformedCookieException {
                if (TextUtils.isEmpty(value)) {
                    // You should set whatever you want in cookie
                    cookie.setExpiryDate(null);
                } else {
                    super.parse(cookie, value);
                }
            }
        });
    }
}