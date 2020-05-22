LocationManager lManager =(LocationManager)this.getSystemService(Context.LOCATION_SERVICE); 
LocationListener = listener = new LocationListener() {

          public void onStatusChanged(String provider, int status, Bundle extras) {           
}

          public void onProviderEnabled(String provider) {
          }


          public void onProviderDisabled(String provider) {
          }

          public void onLocationChanged(Location location) {
          }

      };

lManager.requestLocationUpdates(bestProvider, MINIMUM_TIME_BETWEEN_UPDATES, MINIMUM_DISTANCE_BETWEEN_UPDATES, listener);