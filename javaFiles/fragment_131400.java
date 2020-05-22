// 2. Create the GoogleApi object
GoogleApi = new GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build();

// 3. Create the LocationRequest
mLocationRequest.setInterval(1000); // in milliseconds
mLocationRequest.setFastestInterval(1000); // in milliseconds
mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

// 4. Register your listener
LocationServices.FusedLocationApi.requestLocationUpdates(GoogleApi, mLocationRequest, this)