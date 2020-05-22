mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(MapsActivity.this, marker.getTitle(), Toast.LENGTH_SHORT).show();
        //                                ^^^^^^^^^^^^^^^^^
        return false;
    }
});