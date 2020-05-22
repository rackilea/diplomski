mGoogleApiClient = new GoogleApiClient.Builder(this)
    .addApi(Fitness.SENSORS_API)
    .addApi(Fitness.REPORTING_API)
    .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
    .addConnectionCallbacks(this)
    .addOnConnectionFailedListener(this)
    .build();