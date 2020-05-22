public class WeatherCheck
{
    private ForecastService fs;
    public WeatherCheck(ForecastService fs)
    {
        forecastService = fs;
    }
    public boolean checkForecastIfCityRaining(String name){
        result = forecastService.weatherAPICallToSomeVendor(name)
        if(result = rain)return true; else return false;
}