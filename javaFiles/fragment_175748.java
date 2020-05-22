public Observable<DownloadProgress<File>> downloadFile(@NonNull final String filename) {
    return downloadService.downloadFile(filename)
            .switchMap(response -> Observable.fromEmitter(emitter -> {
                ResponseBody body = response.body();
                final long contentLength = body.contentLength();
                ForwardingSource forwardingSource = new ForwardingSource(body.source()) {
                    private long totalBytesRead = 0L;

                    @Override
                    public long read(Buffer sink, long byteCount) throws IOException {
                        long bytesRead = super.read(sink, byteCount);
                        // read() returns the number of bytes read, or -1 if this source is exhausted.
                        totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                        boolean done = bytesRead == -1;
                        float progress = done ? 1f : (float) bytesRead / contentLength;
                        emitter.onNext(new DownloadProgress<>(progress));
                        return bytesRead;
                    }
                };
                emitter.setCancellation(body::close);
                try {
                    File saveLocation = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile(), filename);
                    saveLocation.getParentFile().mkdirs();
                    BufferedSink sink = Okio.buffer(Okio.sink(saveLocation));
                    sink.writeAll(forwardingSource);
                    sink.close();
                    emitter.onNext(new DownloadProgress<>(saveLocation));
                    emitter.onCompleted();
                } catch (IOException e) {
                    // RxJava1: emitter.onError(e);
                    emitter.tryOnError(e);
                }
            }, Emitter.BackpressureMode.LATEST));
}