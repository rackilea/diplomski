mFusedLocationClient = getFusedLocationProviderClient(this);

//app already crashes once the line below is executed

mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) { 
            }
        });

        latitude = myLocation.getLatitude(); //this line throws NullPointerException 
        longitude = myLocation.getLongitude();