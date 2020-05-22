/**
 * Method used to fetch Map radius
 */
private int getMapRadius() {
    LatLng latlng = googleMap.getProjection().getVisibleRegion().latLngBounds.getCenter();
    if (latLng == null)
        return 0;
    LatLng latLng1 = googleMap.getProjection().getVisibleRegion().farRight;
    return (int) MapUtils.computeDistance(latLng1.latitude, latLng1.longitude, latLng.latitude, latLng.longitude);
}