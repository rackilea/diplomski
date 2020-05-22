@Multipart
@POST("post")
Call<JSONObject> createPost(
    @Part("name") RequestBody name,
    @Part MultipartBody.Part mediaOne,
    @Part MultipartBody.Part mediaTwo,
    @Part MultipartBody.Part mediaThree,
    @Part MultipartBody.Part mediaFour,
    @Part MultipartBody.Part mediaFive,
    @Header("secret_key") int secretKey
);

File file = new File(yourpathhere);
body0 = MultipartBody.Part.createFormData("media_1", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));

RequestBody name = RequestBody.create(MediaType.parse("text/plain"), yourString);


Call<JSONObject> call = apiService.getApi().createPost(
        name,
        body0,
        body1,
        body2,
        body3,
        body4,
        secretKey
        );