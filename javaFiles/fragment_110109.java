public interface API {
@FormURLEncoded
@POST("oauth/access_token")
Call<AccessToken> getAccessToken(
        @Field("client_id") String client_id,
        @Field("client_secret") String client_secret,
        @Field("grant_type") String grant_type,
        @Field("redirect_uri") String redirect_uri,
        @Field("code") String code);
}