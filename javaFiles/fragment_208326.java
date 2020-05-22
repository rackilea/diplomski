LocationListener myLocationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
            String latLongString;
                 TextView myLocationText; 
                 myLocationText=(TextView)findViewById(R.id.textView1);
                 double lat = location.getLatitude();
                 double lng = location.getLongitude();
                 latLongString = "Lat:" + lat + "\nLong:" + lng;
                 myLocationText.setText("Your Current Position is:\n" + 
                           latLongString);
}   
        }

        public void onProviderDisabled(String provider) {

        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status,
                Bundle extras) {
        }
    };

    int t = 5000; // millisekunder
    int dist = 5; // meter
    locationManager.requestLocationUpdates(provider, t, dist, myLocationListener);