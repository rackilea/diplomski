public interface Api {

    @FormUrlEncoded
    @POST("access_token/")
    Call<RedditAccessToken> login (
            @HeaderMap Map<String, String> headers,
            @FieldMap Map<String, String> fields
    );
}