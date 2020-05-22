@FormUrlEncoded
    @Headers(
            {"Authorization: Basic yourAuthHere",
                    "Content-Type: application/x-www-form-urlencoded"}
    )
    @POST("oauth/token")
    Call<JWT> oauthToken(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String grant_type);