/**
 * Called when image data is available after a picture is taken.
 * The format of the data depends on the context of the callback
 * and {@link Camera.Parameters} settings.
 *
 * @param data   a byte array of the picture data
 * @param camera the Camera service object
 */
@Override
public void onPictureTaken(byte[] data, Camera camera) {
    Log.d(TAG, "onPictureTaken() called with: " + "data = [" + Arrays.toString(data) + "], camera = [" + camera + "]");
    handleTakenStill(data);
}

private void handleTakenStill(byte[] data) {
    Log.d(TAG, "handleTakenStill() was called");

    Observable.create(uploadPhoto(data))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<com.squareup.okhttp.Response>() {
                @Override
                public void onCompleted() {
                    Log.d(TAG, "onCompleted() was called");
                }

                @Override
                public void onError(Throwable e) {
                    Utils.logOnFailureRequest(TAG, e);
                }

                @Override
                public void onNext(com.squareup.okhttp.Response response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "handleTakenStill.onResponse success: " + response.body().toString());
                    } else {
                        Log.e(TAG, "handleTakenStill.onResponse error: " + response.message());
                    }
                }
            });
}

@NonNull
private Observable.OnSubscribe<com.squareup.okhttp.Response> uploadPhoto(final byte[] data) {
    return new Observable.OnSubscribe<com.squareup.okhttp.Response>() {
        @Override
        public void call(Subscriber<? super com.squareup.okhttp.Response> subscriber) {
            OkHttpClient client = new OkHttpClient();

            RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
                    .addFormDataPart("camera", "picture_taken.jpg", RequestBody.create(MediaType.parse("image/jpeg"), data))
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .addHeader("content-type", "multipart/form-data")
                    .addHeader("authorization", Utils.encodeUserCredentials())
                    .addHeader("accept", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .build();

            try {
                com.squareup.okhttp.Response response = client.newCall(request).execute();
                subscriber.onNext(response);
                subscriber.onCompleted();
                if (!response.isSuccessful()) {
                    subscriber.onError(new Exception("Error uploading photo"));
                }
            } catch (IOException e) {
                subscriber.onError(e);
            }
        }
    };
}