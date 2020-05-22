public class SortCampgrounds implements Comparator<Campsite> {
    LatLng currentLoc;

    public SortCampgrounds(LatLng current){
        currentLoc = current;
    }
    @Override
    public int compare(final Campsite  campsite1, final Campsite  campsite2) {
        double lat1 = campsite1.getLatitude();
        double lon1 = campsite1.getLongitude();
        double lat2 = campsite2.getLatitude();
        double lon2 = campsite2.getLongitude();

        double distanceToCampsite1 = distance(currentLoc.latitude, currentLoc.longitude, lat1, lon1);
        double distanceToCampsite2 = distance(currentLoc.latitude, currentLoc.longitude, lat2, lon2);
        return (int) (distanceToCampsite1 - distanceToCampsite2);
    }

    public double distance(double fromLat, double fromLon, double toLat, double toLon) {
        double radius = 6378137;   // approximate Earth radius, *in meters*
        double deltaLat = toLat - fromLat;
        double deltaLon = toLon - fromLon;
        double angle = 2 * Math.asin( Math.sqrt(
                Math.pow(Math.sin(deltaLat/2), 2) +
                        Math.cos(fromLat) * Math.cos(toLat) *
                                Math.pow(Math.sin(deltaLon/2), 2) ) );
        return radius * angle;
    }
}