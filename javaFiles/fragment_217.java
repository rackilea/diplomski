if (mGoogleMap == null) {
    mGoogleMap = mMapFragment.getMap();
    if (mGoogleMap != null) {
        initMap();
    }
}