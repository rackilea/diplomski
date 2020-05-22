googleMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
    @Override
    public void onPoiClick(PointOfInterest pointOfInterest) {
        String SS="";
       isPOI=true;
       poiPlaceID=pointOfInterest.placeId;
        // Then using Google PlaceDetail API with placeId, It gives me exact Location click
    }
});