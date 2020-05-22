public class RetrofitClient {


        private static Retrofit retrofit = null;

        public static Retrofit getClient(String baseUrl){
            HeaderInterceptor interceptor = new HeaderInterceptor();
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            if (retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
            }
            return retrofit;
        }
    }