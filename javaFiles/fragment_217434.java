@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.basic_demo);


    mMap = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map2)).getMap();
    mMap.setMyLocationEnabled(true);

     setUpMap();
       findSMSLocation();
    // Setting a custom info window adapter for the google map      
    mMap.setInfoWindowAdapter(new InfoWindowAdapter() {

        // Use default InfoWindow frame
        @Override
        public View getInfoWindow(Marker marker)   {                
            return null;
        }           

        // Defines the contents of the InfoWindow
        @Override
        public View getInfoContents(Marker marker) {

            // Getting view from the layout file info_window_layout
            View v = getLayoutInflater().inflate(R.layout.custom_info, null);

                TextView tvLat = (TextView)  v.findViewById(R.id.info);     
                tvLat.setText("info");
                tvLat.setTextColor(Color.GREEN);

            return v;
        }

    });


}

@Override
protected void onPause() {
    super.onPause();

}

@Override
protected void onResume() {
    super.onResume();
    setUpMapIfNeeded();
}


public void findSMSLocation() {
    // TODO Auto-generated method stub
    try{   

          mMap.addMarker(new MarkerOptions().position(SECC).title("SECC").snippet("Exhibition Way, Glasgow, G3 8YW\nSports: Boxing, Gymnastics, Judo, Netball, Wrestling, Weightlifting"));

          mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SECC, 18.0f));

    }catch(Exception e){

        e.printStackTrace();
    }

}

private void setUpMapIfNeeded() {
    // Do a null check to confirm that we have not already instantiated the map.
    if (mMap == null) {
        // Try to obtain the map from the SupportMapFragment.
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2))
                .getMap();
        mMap.setMyLocationEnabled(true);
        // Check if we were successful in obtaining the map.
        if (mMap != null) {
            setUpMap();
        }
    }
}



private void setUpMap() {
    mMap.getUiSettings().setCompassEnabled(true);
    mMap.getUiSettings().setTiltGesturesEnabled(true);
    mMap.getUiSettings().setRotateGesturesEnabled(true);
    mMap.getUiSettings().setScrollGesturesEnabled(true);
    mMap.getUiSettings().setZoomControlsEnabled(true);
    mMap.getUiSettings().setZoomGesturesEnabled(true);
}

@Override
public boolean onMarkerClick(Marker marker) {
    // TODO Auto-generated method stu
    return false;
}