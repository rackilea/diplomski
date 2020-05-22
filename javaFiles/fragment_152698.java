public class MainActivity extends WearableActivity implements
    GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    LocationListener {

  @Override
  public void onLocationChanged (Location location) {
    // Do something with the location
  }

...
}