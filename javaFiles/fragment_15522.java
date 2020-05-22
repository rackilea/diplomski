Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .client(client) // this is the line you care about
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();