public class MapRequestReceiver extends BroadcastReceiver {

     public static final String ADD_MARKER = "some.unique.string.ADD_MARKER";

     private GoogleMap mMap;

     public MapRequestReceiver (GoogleMap mMap) {
        this.mMap = mMap;
     }

     public void onReceive(Context context, Intent intent) {
        if (intent.getAction().compareTo(ADD_MARKER) == 0) {
           double lat = intent.getDoubleExtra("lat", 0);
           double lng = intent.getDoubleExtra("lng", 0);

           // do something with map using lat/lng
        }
     }

  }