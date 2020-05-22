public static final double RADIUS_EARTH = 6371;

public static Bounds boundsOfCircle(LatLng center, double radius) {
    Bounds bounds = new Bounds();
    double deltaLat = Math.toDegrees(radius / RADIUS_EARTH);
    double deltaLng = Math.toDegrees(radius / RADIUS_EARTH / Math.cos(Math.toRadians(center.lat)));
    bounds.northeast = new LatLng(center.lat + deltaLat, center.lng + deltaLng);
    bounds.southwest = new LatLng(center.lat - deltaLat, center.lng - deltaLng);
    return bounds;
}