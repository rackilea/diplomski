public class Coordinate {
    public double latitude;
    public double longitude;
    public float accuracy;
}

public static Coordinate getGeographicCenter(final ConcurrentLinkedQueue<Coordinate> queue){
    double x = 0;
    double y = 0;
    double z = 0;
    float accuracy = 0;
    int radiusKM = 6367;

    for(final Coordinate coordinate : queue){
        accuracy += coordinate.accuracy;

        // Convert latitude and longitude to radians
        final double latRad = Math.PI * coordinate.latitude / 180;
        final double lonRad = Math.PI * coordinate.longitude / 180;

        // Convert to cartesian coords
        x += radiusKM * Math.cos(latRad) * Math.cos(lonRad);
        y += radiusKM * Math.cos(latRad) * Math.sin(lonRad);
        z += radiusKM * Math.sin(latRad);
    }

    // Get our averages
    final double xAvg = x / queue.size();
    final double yAvg = y / queue.size();
    final double zAvg = z / queue.size();
    final float accuracyAvg = accuracy / queue.size();

    // Convert cartesian back to radians
    final double sphericalLatRads = Math.asin(zAvg / radiusKM);
    final double sphericalLonRads = Math.atan2(yAvg, xAvg);

    // Convert radians back to latitude and longitude
    Coordinate centerPoint = new Coordinate();
    centerPoint.latitude = sphericalLatRads * (180 / Math.PI);
    centerPoint.longitude = sphericalLonRads * (180 / Math.PI);
    centerPoint.accuracy = accuracyAvg;

    return centerPoint;
}