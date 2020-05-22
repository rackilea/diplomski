public class Client {
    private String name, location, latitude, longitude;

    public Client() {}

    public Client(String name, String location, String latitude, String longitude) {
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getLatitude() { return latitude; }
    public String getLongitude() { return longitude; }
}