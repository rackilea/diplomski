public class Geometry {

   @SerializedName("location")
    private Location location;

    @SerializedName("viewport")
    private ViewPort viewPort;

    public Location getLocation() {
        return location;
    }

    public ViewPort getViewPort() {
        return viewPort;
    }
}