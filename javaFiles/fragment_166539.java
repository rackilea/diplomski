public class City
{
    // Instance Variables
    String cityName;
    String cityImageUrl;

    // Constructor Declaration of Class
    public City(String cityName, String cityImageUrl)
    {
        this.cityname = cityName;
        this.cityImageUrl = cityImageUrl;
    }

    // Get City
    public String getCityName()
    {
        return cityName;
    }

    // Set City
    public String setCityName(String name)
    {
        cityName = name;
    }

    // Get City Image Url
    public int getCityImageUrl()
    {
        return cityImageUrl;
    }

    // Set City Image Url
    public String setCityImageUrl(String url)
    {
    cityImageUrl = url;
    }
}