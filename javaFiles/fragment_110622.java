private void getDeviceLocation(){
    try{
        if(mLocationPermissionGranted){
            Task locationResult = mFusedLocationProviderClient.getLastLocation();
            locationResult.addOnCompleteListener(this, new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful() && task.getResult() != null){
                        Log.d(TAG, "onComplete: location found!");
                        Location currentLocation = (Location) task.getResult();

                        float currentZoom = mMap.getCameraPosition().zoom;//edit (added line)

                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currentLocation.getLatitude(),
                                currentLocation.getLongitude()), DEFAULT_ZOOM));//edit (changed line)

                    }else{
                        Log.d(TAG, "onComplete: current location is null");
                        Toast.makeText(MapActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }catch (SecurityException e){

    }
}