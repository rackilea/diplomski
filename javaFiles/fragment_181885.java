public interface Mapable {

    // Marker
    IMarker createMarker(String id, Location location, int icon);
    void addMarker(IMarker marker);
    void removeMarker(String id);
    void moveMarker(String id, Location destination);

    // Camera
    ICamera createCamera();
    void addCamera(ICamera camera);
    // Uncomment this line below if you want to be able to get all cameras
    // ICamera[] getCameras();
    // Uncomment this line below if you want to be able to get the current camera
    // ICamera getCurrentCamera();

    void updateElements();
}