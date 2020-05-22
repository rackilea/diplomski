public class YourActivity extends FragmentActivity implements OnMapClickListener {
   private GoogleMap mMap;
  @Override
  protected void onCreate(Bundle saveInstanceState) { 
    super.onCreate(saveInstanceState);
    ...
    my_map.setOnMapClickListener(this)        
    ...
}

public void onMapClick (LatLng point) {
    // Do Something
   mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
   mMap.addMarker(new MarkerOptions()
    .position(point)
    .title("TouchPoint"));
 }
}