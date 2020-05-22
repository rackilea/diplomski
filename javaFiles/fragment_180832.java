private static GsonConverterFactory buildGsonConverter() {

        final GsonBuilder builder = new GsonBuilder();

        // Adding custom deserializers
        builder.registerTypeAdapter(FooInterface.class, 
                                    new ConvertableDeserializer<FooInterface>());
        final Gson gson = builder.create();

        return GsonConverterFactory.create(myGson);
    }


    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("REST_ENDPOINT")
                .addConverterFactory(buildGsonConverter())
                .client(httpClient)
                .build();
    }