String credentials = "login:password";
    final String basic = "Basic " +
            Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    client.interceptors().add(new Interceptor() {
        @Override
        public com.squareup.okhttp.Response intercept(Interceptor.Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", basic)
                    .method(original.method(), original.body());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    });