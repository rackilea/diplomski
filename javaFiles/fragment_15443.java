interface ApiInterface {

        @GET
        Call<ResponseBody> makeGetRequest(@Url String url, @HeaderMap() Map<String, String> header);

        @POST
        Call<ResponseBody> makePostRequest(@Url String url, @Body RequestBody requestBody, @HeaderMap() Map<String, String> header);
}