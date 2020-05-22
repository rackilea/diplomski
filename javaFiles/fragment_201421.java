public static String WEATHER_URL;

@Value(“${weather.url}")
public void setWehtherUrl(String url) {
    WEATHER_URL= url;
}