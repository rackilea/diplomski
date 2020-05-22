OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request original = chain.request();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-access-token", "eyJhbGci");

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    });

    OkHttpClient client = httpClient.build();



    return new Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();