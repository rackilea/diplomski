public Observable<DownloadProgress<File>> downloadFile(@NonNull final String url, @NonNull final File saveLocation) {
    return Observable.fromEmitter(emitter -> {
        Request request = new Request.Builder()
                .url(url)
                .build();

        final ProgressListener progressListener = (bytesRead, contentLength, done) -> {
            // range [0,1]
            float progress = done ? 1f : (float) bytesRead / contentLength;
            emitter.onNext(new DownloadProgress<>(progress));
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(chain -> {
                    Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                })
                .build();

        final Call call = client.newCall(request);
        emitter.setCancellation(() -> call.cancel());

        try {
            Response response = call.execute();
            BufferedSink sink = Okio.buffer(Okio.sink(saveLocation));
            sink.writeAll(response.body().source());
            sink.close();
            emitter.onNext(new DownloadProgress<>(saveLocation));
            emitter.onCompleted();
        } catch (IOException e) {
            emitter.onError(e);
        }
    }, Emitter.BackpressureMode.LATEST);
}