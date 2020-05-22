//declare constants

 // The minimum distance to change Updates in meters
private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 20; // 10 meters

 // The minimum time between updates in milliseconds
private static final long MIN_TIME_BW_UPDATES = 2000 * 60 * 1; // 1 minute

public void getlocation() 
{  
    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

   // Define the criteria how to select the locatioin provider        
    Criteria criteria = new Criteria();
    provider = locationManager.getBestProvider(criteria, false);
    locationManager.requestLocationUpdates(provider, MIN_TIME_BW_UPDATES,
                  MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

    if (locationManager != null) {
    Location location = locationManager.getLastKnownLocation(provider);

       if (location != null) {
          loclat = location.getLatitude();
          loclong = location.getLongitude();                                
       }
   }
}