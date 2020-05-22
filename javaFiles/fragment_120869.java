public static CliqueDBApiInterface getCliqueDBApiInterface(){

    if(sCliqueDBApiInterface == null){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        sCliqueDBApiInterface = retrofit.create(CliqueDBApiInterface.class);
    }

    return sCliqueDBApiInterface;
}


where okHttpClient = new OkHttpClient.Builder().build();