@Override
protected WebClient modifyWebClient(WebClient client) {
    RefreshHandler rh = new RefreshHandler() {
        public void handleRefresh(final Page page, final URL url, final int seconds) { }
    };
    client.setRefreshHandler(rh);
    return client;
}