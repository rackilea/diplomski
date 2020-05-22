Gson gson = new GsonBuilder()
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    .create();

RestAdapter restAdapter = new RestAdapter.Builder()
    .setEndpoint(API_BASE_URL)
    .setConverter(new GsonConverter.create(gson))
    .build();