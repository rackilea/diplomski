Observable.from(urls)
            .flatMap(url -> restApi.downloadFile(url))
            .concatMap(new Func1<Response<ResponseBody>, Observable<File>>() {
                @Override
                public Observable<File> call(final Response<ResponseBody> responseBodyResponse) {
                    try {
                        File file = new File(parentFolder.getAbsoluteFile(), uri.getLastPathSegment());
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        BufferedSink sink = Okio.buffer(Okio.sink(file));
                        sink.writeAll(responseBodyResponse.body().source());
                        sink.close();
                        return Observable.just(file);
                    } catch (Exception e) {
                        return Observable.error(e);
                    }
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<File>() {

                @Override
                public void onCompleted() {
                    dManager.logMe(TAG, "file download complete");
                }

                @Override
                public void onError(Throwable e) {
                    dManager.logMe(TAG, "file download error");
                    e.printStackTrace();
                }

                @Override
                public void onNext(File file) {
                    dManager.logMe(TAG, "file download onNext: " + file.getAbsolutePath());
                }
            });