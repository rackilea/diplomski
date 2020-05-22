@Override
public void onCreate() {
    super.onCreate();
    googleApiClient = new GoogleApiClient.Builder(this)
        .addApi(LocationServices.API)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .build();
    googleApiClient.connect();
      }