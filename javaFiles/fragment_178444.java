try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

    // use httpClient (no need to close it explicitly)

} catch (IOException e) {

    // handle

}