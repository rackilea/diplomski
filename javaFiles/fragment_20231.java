LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 35000, 10, new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            // the users location changed (e.g. he moved some meters)
            current_location = new LatLng(location.getLatitude(), location.getLongitude());
            // somehow get all the places ( i guess a server backend is recommended )
            // for now, lets say all the places are already obtained into an Arraylist called places:
            ArrayList<LatLng> places = new ArrayList<LatLng>;

            // Go check for each of the places, if the users current location is near to such a point
            for (LatLng place : places) {
                if (distance(place,current_location)<100) {
                    LatLng near_place = place;
                    // here we are! near_place is near the users current location, lets do some action
                    Log.d("app","Users location (" + current_location.latitude +","+current_location.longitude+") is near to a place with coordinates "+near_place.latitude+","+near_place.longitude+").");
                }
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    });
}