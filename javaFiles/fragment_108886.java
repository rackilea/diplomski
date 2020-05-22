retrofit = new Retrofit.Builder()
                .baseUrl("http://www.example.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();