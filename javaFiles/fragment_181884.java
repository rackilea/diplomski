public interface IMarker {
    String getID();
    Location getLocation();
    @DrawableRes
    int getIcon(); // You can also return a Drawable instead, if you want

    // here you can add setters, but I don't think you need to
}

public interface ICamera {
    int getZoom();
    int getMinZoom();
    int getMaxZoom();
    Location getLocation();

    void setZoom(int value);
    void setZoomRange(int min, int max);
    void move(Location location, int zoom);
}