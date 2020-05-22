private <T> T get(String path, Class<T> type) throws IOException {
    HttpGet httpget = new HttpGet(path);
    httpget.setConfig(requestConfig);

    try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
        try (CloseableHttpResponse result = httpClient.execute(apiHost, httpget)) {
            Constructor<T> constructor = type.getConstructor(JSONTokener.class);
            return constructor.newInstance(new JSONTokener(result.getEntity().getContent()));
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException("Provided result class does not accept JSONTokener parameter.");
        }
    }
}