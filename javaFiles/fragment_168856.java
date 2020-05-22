@Override
public void onMyLocationChange(Location location) {
    Location target = new Location("target");
    for(LatLng point : new LatLng[]{POINTA, POINTB, POINTC, POINTD}) {
        target.setLatitude(point.latitude);
        target.setLongitude(point.longitude);
        if(location.distanceTo(target) < METERS_100) {
            // bingo!
        }
    }
}