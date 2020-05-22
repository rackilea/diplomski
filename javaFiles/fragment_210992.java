private void animateMarker(final Marker marker) {
    final Handler handler = new Handler();

    final long startTime = SystemClock.uptimeMillis();
    final long duration = 300; // ms

    Projection proj = mMap.getProjection();
    final LatLng markerLatLng = marker.getPosition();
    Point startPoint = proj.toScreenLocation(markerLatLng);
    startPoint.offset(0, -10);
    final LatLng startLatLng = proj.fromScreenLocation(startPoint);

    final Interpolator interpolator = new BounceInterpolator();

    handler.post(new Runnable() {
        @Override
        public void run() {
            long elapsed = SystemClock.uptimeMillis() - startTime;
            float t = interpolator.getInterpolation((float) elapsed / duration);
            double lng = t * markerLatLng.longitude + (1 - t) * startLatLng.longitude;
            double lat = t * markerLatLng.latitude + (1 - t) * startLatLng.latitude;
            marker.setPosition(new LatLng(lat, lng));

            if (t < 1.0) {
                // Post again 16ms later (60fps)
                handler.postDelayed(this, 16);
            }
        }
    });
}