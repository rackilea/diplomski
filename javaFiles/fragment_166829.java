if ( Build.VERSION.SDK_INT >= 23){
              if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                          PackageManager.PERMISSION_GRANTED  ){
                   requestPermissions(new String[]{
                                      android.Manifest.permission.ACCESS_FINE_LOCATION},
                              REQUEST_CODE_ASK_PERMISSIONS);
                      return ;
                  }
              }

              getLocation();

  }
  //get access to location permission
  final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
      switch (requestCode) {
          case REQUEST_CODE_ASK_PERMISSIONS:
              if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                  getLocation();
              } else {
                  // Permission Denied
                  Toast.makeText( this,"your message" , Toast.LENGTH_SHORT)
                          .show();
              }
              break;
          default:
              super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      }
  }

//Get location
public  void getLocation(){
      LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
          Location myLocation=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
              if (myLocation == null) 
              {
                  myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

              }
  }