private List<Marker> getSurroundingMarkers(List<Marker> markers,
        LatLng origin, int maxDistanceMeters) {
    List<Marker> surroundingMarkers = surroundingMarkers = new ArrayList<Marker>();
    if (markers == null) return surroundingMarkers ;


        for (Marker marker : markers) {

            double dist = distBetween(origin, marker.getPosition());

            if (dist < maxDistanceMeters) {
                surroundingMarkers.add(marker);
            }
        }


    return surroundingMarkers;
}

private float distBetween(LatLng pos1, LatLng pos2) {
    return distBetween(pos1.latitude, pos1.longitude, pos2.latitude,
            pos2.longitude);
}

/** distance in meters **/
private float distBetween(double lat1, double lng1, double lat2, double lng2) {
    double earthRadius = 3958.75;
    double dLat = Math.toRadians(lat2 - lat1);
    double dLng = Math.toRadians(lng2 - lng1);
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(Math.toRadians(lat1))
            * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2)
            * Math.sin(dLng / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double dist = earthRadius * c;

    int meterConversion = 1609;

    return (float) (dist * meterConversion);
}