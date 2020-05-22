public interface pre_upload {
    @Headers({"Contet-Type: application/json"})
    @POST("media/group")
    Call<Object> upload(@Header("auth") String auth,
                        @Body JsonObject json);
}