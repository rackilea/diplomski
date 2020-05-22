LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult result) {
                DebugUtils.log("onLocationResult");
            }

            @Override
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                DebugUtils.log("onLocationAvailability: isLocationAvailable =  " + locationAvailability.isLocationAvailable());
            }
        }, null);