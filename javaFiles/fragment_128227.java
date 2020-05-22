private OkHttpClient provideOkhttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(15000, TimeUnit.MILLISECONDS);
        client.writeTimeout(70000, TimeUnit.MILLISECONDS);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(interceptor);
        return client.build();
    }