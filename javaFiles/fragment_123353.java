public class Data {
    private double latitude;
    private double longitude;
    private String time;
    private int route;

    @JsonCreator
    public Data(@JsonProperty("latitude") double latitude, 
                @JsonProperty("longitude") double longitude, 
                @JsonProperty("time") String time, 
                @JsonProperty("route") int route) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.route = route;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTime() {
        return time;
    }

    public int getRoute() {
        return route;
    }
}