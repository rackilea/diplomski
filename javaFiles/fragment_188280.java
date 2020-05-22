class MyLocationListener implements LocationListener {

    private String longitude;
    private String latitude;


    public String getLongitude(){
        return longitude;
    }

    public String getLatitude(){
        return latitude;
    }

    @Override
    public void onLocationChanged(Location loc) {
        longitude = "Longitude: " + loc.getLongitude();
        Log.v("Long", longitude);
        atitude = "Latitude: " + loc.getLatitude();
        Log.v("Lat", latitude); 
    }

}