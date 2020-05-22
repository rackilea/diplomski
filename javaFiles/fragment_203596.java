HttpRequestInitializer setHttpTimeout(final HttpRequestInitializer requestInitializer) {
    return httpRequest -> {
        requestInitializer.initialize(httpRequest);
        httpRequest.setConnectTimeout(2 * 60000);  // 2 minutes connect timeout
        httpRequest.setReadTimeout(2 * 60000);  // 2 minutes read timeout
    };
}