Handler handler = new Handler(Looper.getMainLooper());

for (int i = 0; i < allPostsMarkers.length(); i++) {

    ...

    final LatLng shipborough = new LatLng(Float.parseFloat(latitude), 
                                          Float.parseFloat(longitude)); 
    handler.post(new Runnable() {
        public void run() {
            mMap.addMarker(new MarkerOptions().position(shipborough)
                                              .title("Post Marker"));
        }
    });
}