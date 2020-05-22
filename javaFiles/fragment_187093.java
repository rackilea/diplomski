CookieManager cookieManager = new CookieManager() {
    protected int getPort(URL url) {

        // or deduct it from url.getProtocol()
        return 80;
    }  
};
webClient.setCookieManager(cookieManager);