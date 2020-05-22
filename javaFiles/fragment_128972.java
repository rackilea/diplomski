public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    // GET ALL CAMPSITES FROM DATABASE
    ArrayList<Campsite> campsites = db.getAllCampsites();

    // LOOP THROUGH EACH CAMPSITE AND ADD A MARKER FOR EACH CAMPSITE
    for (Campsite campsite : campsites) {
        LatLng latLng = new LatLng(campsite.getLatitude(), campsite.getLongitude());
        mMap.addMarker(new MarkerOptions().position(latLng).title(campsite.getName()));
    }

    // PLACE MARKER FOR CURRENT LOCATION (STATIC LOCATION)
    LatLng currentLocation = new LatLng(34.1691, -118.4167);
    mMap.addMarker(new MarkerOptions().position(currentLocation).title("Your location"));

    // Add this to sort and get the closest Campsite:
    Collections.sort(campsites, new SortCampgrounds(currentLocation));

    // Get the first one from the list, this will be the closest:
    Campsite closestCampsite = campsites.get(0);

}