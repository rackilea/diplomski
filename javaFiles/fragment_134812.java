// add a Facebook StethoInterceptor to the OkHttpClient's list of network interceptors
OkHttpClient okClient = new OkHttpClient.Builder()
        .addNetworkInterceptor(new StethoInterceptor())
        .build();

mRetrofit = new Retrofit.Builder()
        .client(okClient)
        .baseUrl(BASE_URL)
        .build();