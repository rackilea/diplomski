public class MyMarker {
    private LatLng position;
    private BitmapDescriptor icon;
    private String title;
    private String snippet;

    public MyMarker(LatLng position, BitmapDescriptor icon, String title, String snippet) {
        this.position = position;
        this.icon = icon;
        this.title = title;
        this.snippet = snippet;
    }

    public LatLng getPosition() {
        return position;
    }

    public BitmapDescriptor getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public MarkerOptions buildGoogleMarker() {
        return new MarkerOptions()
           .position(this.position)
           .icon(this.icon)
           .title(this.title)
           .snippet(this.snippet)
           .anchor(0.5f, 0.5f);
    }
}