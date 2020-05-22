public class MapViewFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_fragment, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
            if(servicesOK()){
                googleMap = mMap;

                // For showing a move to my location button
                googleMap.setMyLocationEnabled(true);

                Geocoder gc = new Geocoder(this);
            List<Address> list;
            try {
                list = gc.getFromLocationName(hotel.getAddress(), 1);
                Address address = list.get(0);
                double lat = address.getLatitude();
                double lng = address.getLongitude();
                LatLng latLong = new LatLng(lat, lng);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLong, 15);
                googleMap.moveCamera(update);



                MarkerOptions options = new MarkerOptions()
                        .title(getString(R.string.landon_hotel) + ", " + city)
                        .position(new LatLng(lat, lng));
                googleMap.addMarker(options);

            } catch (IOException e) {
                Toast.makeText(this, getString(R.string.error_finding_hotel), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(this.getLocalClassName(), e.getMessage());
            }
            }
            }



        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
     public boolean servicesOK() {
        int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (result == ConnectionResult.SUCCESS) {
            return true;
        } else if (GooglePlayServicesUtil.isUserRecoverableError(result)) {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(result, this, DIALOG_REQUEST);
            dialog.show();


        } else {


         Toast.makeText(this, getString(R.string.error_connect_to_services), 
         Toast.LENGTH_SHORT).show();

       }

        return false;

           }

       }