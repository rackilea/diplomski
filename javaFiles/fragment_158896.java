OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES); // read timeout

    client = builder.build();