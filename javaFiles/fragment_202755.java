private NetworkingAction(){
    long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MB
    Cache cache = new Cache(getCacheDir(), SIZE_OF_CACHE);

    OkHttpClient okClient = new OkHttpClient
            .Builder()
            .addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
            .addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
            .cache(cache)
            .build();

    NetworkInterface service = new Retrofit.Builder()
            .baseUrl(ServerConstants.API_URL)
            .client(okClient)
            .build()
            .create(NetworkInterface.class);

    service.getSomething().clone().enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            Log.d("TAG", "onResponse: ");
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            Log.d("TAG", "onFailure: " + t.getMessage());
        }
    });
}

private final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());
        String cacheControl = originalResponse.header("Cache-Control");
        if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")) {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 5000)
                    .build();
        } else {
            return originalResponse;
        }
    }
};

private final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = new Interceptor() {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetworkUtils.isNetworkAvailable(VenueDetailsActivity.this)) {
            request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached")
                    .build();
        }
        return chain.proceed(request);
    }
};
public static boolean isOnline() {
     ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
     NetworkInfo netInfo = cm.getActiveNetworkInfo();
     return netInfo != null && netInfo.isConnectedOrConnecting();