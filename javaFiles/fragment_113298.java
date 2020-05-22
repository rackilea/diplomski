BrowserMobProxy proxy = new BrowserMobProxyServer();
    proxy.start();

    proxy.addRequestFilter(new RequestFilter() {
        @Override
        public HttpResponse filterRequest(HttpRequest request, HttpMessageContents contents, HttpRequest originalRequest) {
            request.headers().add("Cookie", "added-cookie=added-value");

            return null;
        }
    });