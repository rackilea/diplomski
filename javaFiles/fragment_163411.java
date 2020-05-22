public class WeatherDescrip {
    private String weather;
    private String weather_Desc;
    private String icon;

    public WeatherDescrip(String weather, String weather_Desc, String icon) {
        this.weather = weather;
        this.weather_Desc = weather_Desc;
        this.icon = icon;
    }
}

...

public static WeatherDescrip createWeatherDescrip(JSONObject weatherObj) {
    if (!weatherObj.containsKey("main") 
        || !weatherObj.containsKey("description")
        || !weatherObj.containsKey("icon")) {
        throw SomeNewMeaningfulException("That I understand and can explicitly handle");
        or....
        return getMyDataFromSomeWhereElse();
    }

    return new WeatherDescrip(
        weatherObj.getString("main"),
        weatherObj.getString("description"),
        weatherObj.getString("icon")
    );
}