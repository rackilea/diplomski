@FormUrlEncoded
@GET("get_user_info")
Call<ResponseBody> getUserMeta(
    @Query("id") int userId,
    @Query(value ="cookie", encode = true) String cookie

    );