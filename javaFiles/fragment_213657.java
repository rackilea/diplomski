@GET
Call<ResponseBody> downloadUrl(@Header(Constants.AUTHORIZATION) String header, @Url String url);
OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(ConfigContentsManager.getInstance().getReadTimeOut(), TimeUnit.SECONDS)
            .connectTimeout(ConfigContentsManager.getInstance().getConnectionTimeOut(), TimeUnit.SECONDS)
            .build();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ServerManager.getInstance().getCmsUrl())
            .client(okHttpClient)
            .build();

    RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
    Call<ResponseBody> request =null;

        request= retrofitInterface.downloadUrl("...","....");

    request.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

        }
    });