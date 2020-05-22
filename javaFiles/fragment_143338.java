final AtomicLong totalBytes = new AtomicLong();

HttpRequestExecutor requestExecutor = new HttpRequestExecutor() {

    @Override
    protected HttpResponse doSendRequest(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws IOException, HttpException {
        HttpResponse response = super.doSendRequest(request, conn, context);
        HttpConnectionMetrics metrics = conn.getMetrics();
        totalBytes.addAndGet(metrics.getSentBytesCount());
        metrics.reset();
        return response;
    }

    @Override
    protected HttpResponse doReceiveResponse(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) throws HttpException, IOException {
        HttpResponse response = super.doReceiveResponse(request, conn, context);
        HttpConnectionMetrics metrics = conn.getMetrics();
        totalBytes.addAndGet(metrics.getReceivedBytesCount());
        metrics.reset();
        return response;
    }
};

CloseableHttpClient httpclient = HttpClients
        .custom()
        .setRequestExecutor(requestExecutor)
        .build();