Interceptor tokenInterceptor = new TokenInterceptor(provideUserLoginDao(appDatabase));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(tokenInterceptor)
                .writeTimeout(50, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();