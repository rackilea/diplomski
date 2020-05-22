public class MainActivity extends ActionBarActivity implements
    ConnectionCallbacks, OnConnectionFailedListener {

Location mLastLocation;
TextView mLatitudeText,mLongitudeText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

   mLatitudeText=(TextView)findViewById(R.id.textview1);
   mLongitudeText=(TextView)findViewById(R.id.textview2); 
 }


...
@Override
public void onConnected(Bundle connectionHint) {
    mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
            mGoogleApiClient);
    if (mLastLocation != null) {
        mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
        mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
    }
  }
}