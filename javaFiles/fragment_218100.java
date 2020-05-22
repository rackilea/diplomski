@Multipart
@POST("update-profilePatient")
Call<ResponseBody> updatePatientsWithePhoto
(@Part("user_id") RequestBody user_id,
 @Part("firstname") RequestBody firstname,
 @Part("lastname") RequestBody lastname,
 @Part("birthday") RequestBody birthday,
 @Part("phone") RequestBody phone,
 @Part("gender") RequestBody gender,
 @Part("city_id") RequestBody city_id,
 @Part("area_id") RequestBody area_id,
 @Part("Address") RequestBody Address,
 @Part("latitude") RequestBody latitude,
 @Part("longitude") RequestBody longitude,
 @Part("other") RequestBody other,@Part MultipartBody.Part image);