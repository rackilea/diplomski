// try this
public static LocationManager mlocManager;
public static LocationListner mListner;
private static String latitude;
public static String longitude;
private Location currentLocation;

public Location getCurrentLocation() {
  return currentLocation;
}

public void setCurrentLocation(Location currentLocation) {
   this.currentLocation = currentLocation;
}

try {
mlocManager = (LocationManager) getSystemService(Activity.LOCATION_SERVICE);
                mListner = new LocationListner();
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                        try {
                            mlocManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, mListner);
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }

                            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mListner);
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                        try {
                            mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, mListner);
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }

                    }
                });
} catch (Throwable e) {
    e.printStackTrace();
}

    public String getLatitude() {
        if (latitude != null) {
            return latitude;
        }
        Location loc = mlocManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc == null) {
            loc = mlocManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (loc == null) {
                loc = mlocManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            }
            if (loc != null) {
                return "" + loc.getLatitude();
            }
        } else {
            return "" + loc.getLatitude();
        }
        return "0.0";
    }

    public void setLatitude(String latitide) {
        latitude = latitide;
    }

    public String getLongitude() {
        if (longitude != null) {
            return longitude;
        }
        Location loc = mlocManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc == null) {
            loc = mlocManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (loc == null) {
                loc = mlocManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            }
            if (loc != null) {
                return "" + loc.getLongitude();
            }
        } else {
            return "" + loc.getLongitude();
        }
        return "0.0";
    }

    public void setLongitude(String longitude) {
        SmartActivity.longitude = longitude;
    }

    class LocationListner implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            setLatitude("" + location.getLatitude());
            setLongitude("" + location.getLongitude());
            setCurrentLocation(location);
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

    }