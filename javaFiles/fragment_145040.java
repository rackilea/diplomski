BuildRetrofit(){
 mOkHttpClient = new OkHttpClient.Builder()
                 .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        mConverterFactory = GsonConverterFactory.create();
    String baseUrl = "http://dev.appslanka.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(mConverterFactory)
                .build();
        mApi = retrofit.create(ApiInterface.class);
        }