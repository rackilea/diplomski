private void sendRequest(Consumer<String> onSucces, String url) {
    SSLContext context;
    try {
        context = SSLContext.getInstance("TLSv1.3");
        context.init(null, null, null);
    } catch (GeneralSecurityException e) {
        throw new RuntimeException(e);
    }

    HttpClient client = HttpClient.newBuilder().sslContext(context).build();
    HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();

    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(onSucces)
            .join();
}