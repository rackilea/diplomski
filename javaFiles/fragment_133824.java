class OkHttpClientExt extends OkHttpClient {
    static final Object TAG_CALL = new Object();

    @Override
    public Call newCall(Request request) {
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.tag(TAG_CALL);
        return super.newCall(requestBuilder.build());
    }
}