public class City {

    private int zipCode;
    private String cityName;

    public City(int zipCode, String cityName) {
        this.zipCode=zipCode;
        this.cityName=cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }

}