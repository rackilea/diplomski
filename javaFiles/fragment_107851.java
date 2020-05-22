private TextView lala;

LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

if(location != null) {
    showMyAddress(location);
}

final LocationListener locationListener = new LocationListener() {
    public void onLocationChanged(Location location) {
        showMyAddress(location);
    }

    public void onProviderDisabled(String arg0) {
        // TODO Auto-generated method stub

    }

    public void onProviderEnabled(String arg0) {
        // TODO Auto-generated method stub

    }

    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        // TODO Auto-generated method stub

    }
};

lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
lala = (TextView) findViewById(R.id.textView1);



// Also declare a private method

private void showMyAddress(Location location) {
    double latitude = location.getLatitude();
    double longitude = location.getLongitude();
    Geocoder myLocation = new Geocoder(getApplicationContext(), Locale.getDefault());   
    List<Address> myList;
    try {
        myList = myLocation.getFromLocation(latitude, longitude, 1);
        if(myList.size() == 1) {
            lala.setText(myList.get(0).toString());             
        }
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
}