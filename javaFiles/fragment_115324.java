private void mapMoveTo(double lat, double lng){
    LatLng latLng = new LatLng(lat, lng);
    if(mMap != null){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomFactor));
    }
}