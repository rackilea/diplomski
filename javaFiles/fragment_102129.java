OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {

            Request originalRequest = chain.request(); //Current Request

            Response response = chain.proceed(originalRequest); //Get response of the request

            //I am logging the response body in debug mode. When I do this I consume the response (OKHttp only lets you do this once) so i have re-build a new one using the cached body
            String bodyString = response.body().string();

            Log.i("NetworkModule", String.format("Sending request %s with headers %s ", originalRequest.url(), originalRequest.headers()));
            Log.i("", (String.format("Got response HTTP %s %s \n\n with body %s \n\n with headers %s ", response.code(), response.message(), bodyString, response.headers())));

            response = response.newBuilder().body(
                    ResponseBody.create(response.body().contentType(), bodyString))
                    .build();

            return response;
        }
    }).connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).build();