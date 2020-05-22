locationRetrieveButton.setOnTouchListener(retrieveButtonClicked);
    Location location = null;
    LocationManager locationManager=null;
      final View.OnTouchListener retrieveButtonClicked = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        try {
            locationManager = (LocationManager) getContext()
                    .getSystemService(Context.LOCATION_SERVICE);

            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            isNetworkEnabled = locationManager
                        .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if (isGPSEnabled || isNetworkEnabled) { // Internet Or Gps Control

                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                } //Check Permission

                    if (isGPSEnabled) { //Check Gps Enabled
                        if (location == null) {
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000 , 10,
                                    new LocationListener() {
                                        @Override
                                        public void onStatusChanged(String provider, int status, Bundle extras) {
                                        }

                                        @Override
                                        public void onProviderEnabled(String provider) {
                                        }

                                        @Override
                                        public void onProviderDisabled(String provider) {
                                        }

                                        @Override
                                        public void onLocationChanged(final Location location) {
                                        }
                                    });

                            if (locationManager != null) {
                                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


                            }

                        }}



                    //Check Network Enabled
                    if (isNetworkEnabled) {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                2000,
                                10,  new LocationListener() {
                                    @Override
                                    public void onStatusChanged(String provider, int status, Bundle extras) {
                                    }

                                    @Override
                                    public void onProviderEnabled(String provider) {
                                    }

                                    @Override
                                    public void onProviderDisabled(String provider) {
                                    }

                                    @Override
                                    public void onLocationChanged(final Location location) {
                                    }
                                });

                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        }
                    }


            }
             else {
                AlertDialog alertMessage = new AlertDialog.Builder(getActivity()).create();
                alertMessage.setTitle("Message");
                alertMessage.setMessage("Please Open Internet Or Gps");
                alertMessage.show();
            }
            }

     catch (Exception e) {
        e.printStackTrace();
    }
    }
});