public interface CurrentWeatherApi {

    @GET("/data/2.5/weather")
    Call<CurrentWeather> getCurrentWeather(@Query("q") String cityName,@Query("APPID") String appID);

}