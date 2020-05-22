protected synchronized void buildGoogleApiClient() {
        if (checkPlayServices()) {
                    .requestServerAuthCode(BuildConfig.GOOGLE_WEB_CLIENT_ID)
                    .requestEmail()
                    .build();
            // Build a GoogleApiClient with access to the Google Sign-In API and the
            // options specified by gso.
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(/*Api for google Drive*/)
                    .enableAutoManage(this, this)
                    .build();
            mGoogleApiClient.connect();

        }
    }