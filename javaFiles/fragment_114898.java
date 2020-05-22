//instance variables
 private GoogleMap googleMap;
 private double longitude = 0.0;
 private double latitude = 0.0;
 private LocationManager locationManager = null;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);   // your layout
  try {
    initilizeMap();     

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1, this);

    googleMap.setMyLocationEnabled(true);   
    googleMap.getUiSettings().setMyLocationButtonEnabled(true);

   }
 } catch (Exception e) {
        e.printStackTrace();
 }
 }


 private void initilizeMap() {
    if (googleMap == null) {
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                R.id.map)).getMap();    //provide your id       

        // check if map is created successfully or not
        if (googleMap == null) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}

    @Override
    public void onLocationChanged(Location location) {
       // TODO Auto-generated method stub
       longitude = location.getLongitude();
      latitude = location.getLatitude();
      //System.out.println(latitude+ " "+longitude );
      if(!isStopFocusEnabled){
          CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(latitude, longitude)).zoom(12).build(); 
          googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
       }


}