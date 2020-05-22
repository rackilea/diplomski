@FormUrlEncoded
@PUT(ApiConstants.REGISTER_URL_PART)
Call<RegisterModel> registerUser(
        @Field("username") String username,
        @Field("email") String email,
        @Field("password") String password,
        @Field("fbID") String fbID,
        @Field("gmailID") String gmailID,
        @Field("twitID") String twitID,
        @Field("gender") String gender,
        @Field("birthDate") String birthDate,
        @Nullable @Field("location") String location,
        @Nullable @Field("longitude") String longitude,
        @Nullable @Field("latitude") String latitude,
        @Field("profileImage") String profileImage
);