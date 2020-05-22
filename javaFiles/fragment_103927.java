LocationListener locationListenerGps = new LocationListener() {

            // This will never be called, its not part of the LocationListener interface - http://developer.android.com/reference/android/location/LocationListener.html
            /* public void onStatusChanged(Location location) {
                    timer1.cancel();

                    locationResult.gotLocation(location);
                    lm.removeUpdates(this);
                    lm.removeUpdates(locationListenerNetwork);
            } */
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
            public void onLocationChanged(Location location) {
                    // This is the correct method to receive location callbacks
                    timer1.cancel();

                    locationResult.gotLocation(location);
                    lm.removeUpdates(this);
                    lm.removeUpdates(locationListenerNetwork);

            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
    };