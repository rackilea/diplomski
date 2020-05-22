OkHttpClient httpClient = new OkHttpClient.Builder().build();
Gson gson = new GsonBuilder()
                                       .setLenient()
                                       .create();
Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(RestAPI.BASE_URL).client(httpClient).build();

RestAPI service = retrofit.create(RestAPI.class);
Call<TransactionResponse> meResponse = service.loadData("1", getUUID(), getUserAgent(), getIPAddress(), "20404", "start");