public interface RemoteApi {
    @Streaming  // Important
    @POST("/api/DownloadFileForAndroid")
    Call<ResponseBody> getImage(@Body ImageRequest body);

    class Factory {
        private static RemoteApi mInstance;

        public static RemoteApi create() {
            if (mInstance == null) {
                mInstance = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://shop.atiafkar.ir")
                        .build()
                        .create(RemoteApi.class);
            }
            return mInstance;
        }
    }
}