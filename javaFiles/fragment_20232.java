/**
 * method calculate distance between two LatLng points in meter
 */
public float distance(double lat_a, double lng_a, double lat_b, double lng_b) {
    double earthRadius = 3958.75;
    double latDiff = Math.toRadians(lat_b - lat_a);
    double lngDiff = Math.toRadians(lng_b - lng_a);
    double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
            Math.cos(Math.toRadians(lat_a)) * Math.cos(Math.toRadians(lat_b)) *
                    Math.sin(lngDiff / 2) * Math.sin(lngDiff / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = earthRadius * c;

    int meterConversion = 1609;

    return new Double(distance * meterConversion).floatValue();
}