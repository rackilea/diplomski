public RestAdapter providesRestAdapter(Gson gson) {
    final OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
    okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);

    return new RestAdapter.Builder()
        .setEndpoint(BuildConfig.BASE_URL)
        .setConverter(new GsonConverter(gson))
        .setClient(new OkClient(okHttpClient))
        .build();
}