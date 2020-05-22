private Retrofit getClient(String WsPrefix) {
        //TODO 60 to 30 second at everywhere
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(WsPrefix)
                .client(okHttpClient)
                .build();
        return retrofit;
    }