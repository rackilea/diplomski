protected synchronized void buildGoogleApiClient(){
    mGoogleApiLocation = new GoogleApiClient.Builder(context)
            .addConnectionCallbacks(mGoogleApiLocationCallback)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build();
    mGoogleApiAutoComplete = new GoogleApiClient.Builder(context)
            .addConnectionCallbacks(mGoogleApiAutoCompleteCallback)
            .addApi(Places.GEO_DATA_API)
            .enableAutoManage(this,GOOGLE_API_CLIENT_ID,this)
            .build();
}