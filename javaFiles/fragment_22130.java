private void downloadFile() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("yourwebsite/api/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        FileDownloadClient fileDownloadClient = retrofit.create(FileDownloadClient.class);

        Map<String, Object> postdata = new HashMap<>();
        postdata.put("user", "test@test.com");
        postdata.put("test", "test");

        Call<ResponseBody> call = fileDownloadClient.downloadFileStream(postdata);
}