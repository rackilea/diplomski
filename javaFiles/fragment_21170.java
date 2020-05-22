OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

httpClient.addInterceptor(new Interceptor() {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("parameter", "value").build();
        return chain.proceed(request);
    }
});
Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(url).client(httpClient.build()).build();