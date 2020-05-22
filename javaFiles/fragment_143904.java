LocationManager locationManager = (LocationManager)context.getSystemService( Context.LOCATION_SERVICE );

    Criteria criteria = new Criteria();
    criteria.setAccuracy( Criteria.ACCURACY_COARSE );
    String provider = locationManager.getBestProvider( criteria, true );

    if ( provider == null ) {
        Log.e( TAG, "No location provider found!" );
        return;
    }

    lastLocation = locationManager.getLastKnownLocation(provider);