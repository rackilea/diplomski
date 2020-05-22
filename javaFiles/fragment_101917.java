IOReactorConfig reactorConfig = IOReactorConfig.custom()
        .setConnectTimeout(TIMEOUT_5_MINS_IN‌​_MILLIS)
        .setSoTimeout(TIMEOUT_5_MINS_IN_MILLIS).build();

try (CloseableHttpAsyncClient asyncClient = HttpAsyncClients.custom()
        .setDefaultIOReactorConfig(reactorC‌​onfig)
        .setDefaultHeaders(Collections.singletonList(oauthHeader‌​))
        .setMaxConnPerRout‌​e(MAX_CONN)
        .setMaxConnTotal(MAX_CONN).build();) {
    // ...
}