cnt = new MapContainer(new GoogleMapsProvider(""));
cnt.setMapType(MAP_TYPE_TERRAIN);

LocationManager locationManager = LocationManager.getLocationManager();
Location loc = locationManager.getLastKnownLocation(); //default
if (locationManager.isGPSDetectionSupported()) {
    if (locationManager.isGPSEnabled()) {
        InfiniteProgress ip = new InfiniteProgress();
        Dialog ipDlg = ip.showInifiniteBlocking();
        Location loc2 = locationManager.getCurrentLocationSync(30000);
        if (loc2 != null) {
            loc = loc2;
        }
    } else {
        Dialog.show("Location Error", "Unable to find your current location, please be sure that your GPS is turned on", "OK", null);
    }
} else {
    InfiniteProgress ip = new InfiniteProgress();
    Dialog ipDlg = ip.showInifiniteBlocking();
    Location loc2 = locationManager.getCurrentLocationSync(30000);
    if (loc2 != null) {
        loc = loc2;
    } else {
        loc = LocationManager.getLocationManager().getCurrentLocation();
    }
}
if (loc != null) {
    double lat = loc.getLatitude();
    double lng = loc.getLongitude();
    Coord coordinate = new Coord(lat, lng);
}