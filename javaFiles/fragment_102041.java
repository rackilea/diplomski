DefaultHttpClient client = new DefaultHttpClient();
client.getCookieSpecs().register("lenient", new CookieSpecFactory() {
        public CookieSpec newInstance(HttpParams params) {
            return new LenientCookieSpec();
        }
    });
HttpClientParams.setCookiePolicy(client.getParams(), "lenient");