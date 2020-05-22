GoogleMap mMap;

@Override
protected void onStart() {
    super.onStart();

    mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

    // Enable user's location layer
    mMap.setMyLocationEnabled(true);

    mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            // Location lat-lng
            LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());

            // Location accuracy diameter (in meters)
            float accuracy = location.getAccuracy() * 2;

            // Screen measurements
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            // Use min(width, height) (to properly fit the screen
            int screenSize = Math.min(metrics.widthPixels, metrics.heightPixels);

            // Equators length
            long equator = 40075004;

            // The meters per pixel required to show the whole area the user might be located in
            double requiredMpp = accuracy/screenSize;

            // Calculate the zoom level
            double zoomLevel = ((Math.log(equator / (256 * requiredMpp))) / Math.log(2)) + 1;

            Log.e(TAG, String.format("Accuracy: %f. Screen Width: %d, Height: %d",
                    accuracy, metrics.widthPixels, metrics.heightPixels));
            Log.e(TAG, String.format("Required M/Px: %f Zoom Level: %f Approx Zoom Level: %d",
                    requiredMpp, zoomLevel, calculateZoomLevel(screenSize, accuracy)));

            // Center to user's position
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, (float) zoomLevel));

            // Prevent the camera centering on the user again
            mMap.setOnMyLocationChangeListener(null);
        }
    });

}

private int calculateZoomLevel(int screenWidth, float accuracy) {
    double equatorLength = 40075004; // in meters
    double metersPerPixel = equatorLength / 256;
    int zoomLevel = 1;
    while ((metersPerPixel * (double) screenWidth) > accuracy) {
        metersPerPixel /= 2;
        zoomLevel++;
    }

    return zoomLevel;
}