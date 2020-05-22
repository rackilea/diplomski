interface IGeoService {

    @GET("geocode/json")
    Call<Void> getAddressByLocation(@Query("latlng") LatLng latLng, @Query("key") String key);

}