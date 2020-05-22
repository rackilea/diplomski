public class Result {

    @SerializedName("geometry")
    private Geometry getGeometry;

    @SerializedName("icon")
    private String icon;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("vicinity")
    private String vicinity;

    public Geometry getGetGeometry() {
        return getGeometry;
    }

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVicinity() {
        return vicinity;
    }
}