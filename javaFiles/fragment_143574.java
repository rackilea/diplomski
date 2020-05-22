public void getCurrentLocation(){
        //Request permission here
        mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mCurrentLocation != null){
            lat = mCurrentLocation.getLatitude();
            lon = mCurrentLocation.getLongitude();
            Log.i(TAG, "getCurrentLocation(): " + String.valueOf(mCurrentLocation.getLatitude()));
            Log.i(TAG, "getCurrentLocation(): " + String.valueOf(mCurrentLocation.getLongitude()));
        }
    }