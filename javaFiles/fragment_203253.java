@Multipart
    @Headers({"Accept: application/json"})
    @POST("api/save")
    Call<SaveResponse> save(@Header("Authorization") String authorization,
                                       @PartMap Map<String, RequestBody> map,
                                       @Part List<MultipartBody.Part> files);