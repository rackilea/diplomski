public class ViewPort {

    @SerializedName("northeast")
    private NorthEast northEast;

    @SerializedName("southwest")
    private SouthWest southWest;

    public NorthEast getNorthEast() {
        return northEast;
    }

    public SouthWest getSouthWest() {
        return southWest;
    }
}