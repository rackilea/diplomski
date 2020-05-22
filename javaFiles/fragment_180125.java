runOnUiThread(new Runnable() {
    @Override
    public void run() {
        final Marker marker =  mMap.addMarker(new MarkerOptions()
            .position(new LatLng(0, 0))
            .title("Hello world")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.planemarker)));
        markers.add(marker);
    }
});