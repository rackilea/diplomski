HashMap<String, Object> markers = new HashMap<>();

public void createMarker(String routeId, LatLng latLng, String address, String time) {    
    // Create a unique ID for this marker (but don't actually store it yet)
    String markerId = schoolReference.child("markers").push().getKey();

    // Add the marker to the HashMap
    FirebaseMarker marker = new FirebaseMarker(address, time, latLng.getLatitude(), latLng.getLongitude(), routeId);
    markers.put(markerId, marker);

    // Add an actual map marker to the map
    mMap.addMarker(new MarkerOptions()
        .position(latLng)
        .title(address)
        .snppet(time)
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
    );
}