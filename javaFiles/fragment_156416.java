class BackoffRetryInteceptor implements Interceptor {
    private static final long RETRY_INITIAL_DELAY = 500;
    private static final long RETRY_MAX_DELAY = 35000;

    @Override
    public Response intercept(final Chain chain) throws IOException {
        Request request = chain.request();

        final Headers.Builder headersBuilder = new Headers.Builder();
        addHeaders(headersBuilder);

        final Headers headers = headersBuilder.build();
        long delay = RETRY_INITIAL_DELAY;
        Response response = null;
        IOException exception = null;

        while (delay < RETRY_MAX_DELAY) {
            exception = null;
            request = request.newBuilder().headers(headers).build();

            try {
                response = chain.proceed(request);

                if (response.isSuccessful() || response.code() != 500) {
                    return response;
                }
            } catch (IOException e) {
                exception = e;
            }

            try {
                Thread.sleep(delay);
                delay *= 2;
            } catch (InterruptedException e) {
                delay = RETRY_MAX_DELAY;
            }
        }

        if (exception != null) {
            throw exception;
        }

        return response;
    }

    private static void addHeaders(final Headers.Builder headers) {
        headers.add("Header1-name", "Header1-value")
                .add("Header2-name", "Header2-value")
                ...
                .add("HeaderN-name", "HeaderN-value")
                .add("Request-Id", UUID.randomUUID().toString());
    }
}