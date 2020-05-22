public interface RegistrationClient {

    @FormUrlEncoded
    @POST("/api/apiregistration.php")
    void connect(@Field("country") String country,
            @Field("state") String state, @Field("email") String email, 
            @Field("pwd") String password,
            Callback<RegistrationResult> resp);

}