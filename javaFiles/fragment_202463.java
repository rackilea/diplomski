@FormUrlEncoded
@POST("oauth/token")
Call<List<AuthModel>> auth(
    @Field("username") String username,
    @Field("password") String password,
    @Field("grant_type") String grant_type,
    @Field("client_id") Integer client_id,
    @Field(

"client_secret") String client_secret
        );