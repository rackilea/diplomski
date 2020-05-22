longTimeOutHttpClient = new OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .build();
    longTimeoutRetrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient);
    longTimeOutRetrofit = longTimeoutRetrofitBuilder.baseUrl(URIs.BASE_URL + 
    URIs.API_VERSION).build();

    longTimeoutService = longTimeOutRetrofit.create(RestAPI.class);