public void loadImageWithPicasso(ImageView imageView) {
    Picasso.Builder builder = new Picasso.Builder(imageView.getContext());
    RequestCreator picassoImageLoader = createPicassoLoader(
            builder,
            ImageRequest.DEFAULT_JSON_BODY,
            "http://shop.atiafkar.ir/api/DownloadFileForAndroid"
    );
    picassoImageLoader.into(imageView);
}

public RequestCreator createPicassoLoader(Picasso.Builder builder, String body, String url) {
    return builder.downloader(new OkHttp3Downloader(createPicassoCallFactory(body)))
            .build()
            .load(url);
}

private okhttp3.Call.Factory createPicassoCallFactory(String jsonBody) {
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .build();
    final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonBody);
    return new okhttp3.Call.Factory() {
        @Override
        public okhttp3.Call newCall(Request request) {
            Request.Builder builder = request.newBuilder();
            builder.post(requestBody);
            builder.addHeader("Content-Type", "application/json");
            return okHttpClient.newCall(builder.build());
        }
    };
}