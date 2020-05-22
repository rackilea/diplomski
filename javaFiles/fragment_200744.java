....
    LatLng latLng = getLocationFromAddress(TheNameOfActivity.this, "london");
    if(latLng != null){
        MarkerOptions options = new MarkerOptions().position(latLng);
        if(googleMap != null){
            googleMap.addMarker(options);
        {
    }
}