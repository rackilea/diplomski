protected void onCreate(Bundle savedInstanceState)
        {    
            setUpMap();
            displayLocationOnMap();
        }

     private void setUpMap()
            {

                if (mMap == null)
                {
                    mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapview)).getMap();

                    if (mMap != null)
                    {
                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        {
                            @Override
                            public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker)
                            {
                                marker.showInfoWindow();
                                return true;
                            }
                        });
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Unable to create Maps", Toast.LENGTH_SHORT).show();
                }
            }

    private void displayLocationOnMap()
    {
    Marker currentMarker = null;

                currentMarker = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(latitude, longitude))
 .title(Location)    .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_view)));

                currentMarker.isInfoWindowShown();
                currentMarker.setVisible(true);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude(),longitude()), 8.0f));

                mMap.setTrafficEnabled(true);
                mMap.setBuildingsEnabled(true);
                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
    }


public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
    {
        public MarkerInfoWindowAdapter()
        {
        }

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker)
        {
            View v = getLayoutInflater().inflate(R.layout.custom_map_layout, null);

            MyMarker myMarker = mMarkersHashMap.get(marker);

            TextView marker_latitude = (TextView) v.findViewById(R.id.marker_latitude);

            TextView marker_longitude = (TextView) v.findViewById(R.id.marker_longitude);



            marker_latitude.setText("Latitude :" + latitude);

            marker_longitude.setText("Longitude:" +longitude);

            return v;
        }
    }