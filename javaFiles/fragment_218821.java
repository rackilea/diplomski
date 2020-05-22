public class WhereIActivity extends MapActivity {


      // MapController mc;
       MapView myMapView;
       MapController mapController;
       GeoPoint point;
       MyPositionOverlay positionOverlay;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_i);

        MapView myMapView=(MapView)findViewById(R.id.myMapView);

        mapController=myMapView.getController();


       myMapView.displayZoomControls(false);

       mapController.setZoom(17);

       positionOverlay=new MyPositionOverlay();
       List<Overlay> overlays=myMapView.getOverlays();
       overlays.add(positionOverlay);

      // myMapView.setSatellite(true);

       myMapView.setStreetView(true);
       myMapView.setTraffic(true);





        LocationManager locationManager; 
        String context = Context.LOCATION_SERVICE; 
        locationManager = (LocationManager)getSystemService(context); 

        Criteria crta = new Criteria(); 
        crta.setAccuracy(Criteria.ACCURACY_FINE); 
        crta.setAltitudeRequired(false); 
        crta.setBearingRequired(false); 
        crta.setCostAllowed(true); 
        crta.setPowerRequirement(Criteria.POWER_LOW); 
        String provider = locationManager.getBestProvider(crta, true); 

     // String provider = LocationManager.GPS_PROVIDER; 
        Location location = locationManager.getLastKnownLocation(provider); 
        updateWithNewLocation(location); 

        locationManager.requestLocationUpdates(provider, 2000, 10, locationListener); 
        } 
    private final LocationListener locationListener = new LocationListener() 
    { 

    @Override 
    public void onLocationChanged(Location location) { 
    updateWithNewLocation(location); 
    } 

    @Override 
    public void onProviderDisabled(String provider) { 
    updateWithNewLocation(null); 
    } 

    @Override 
    public void onProviderEnabled(String provider) { 
    } 

    @Override 
    public void onStatusChanged(String provider, int status, Bundle extras) { 
    } 

    }; 

    private void updateWithNewLocation(Location location) { 
        String latLong;
        TextView myLocation; 
        myLocation = (TextView) findViewById(R.id.myLocation); 

        String addressString = "no address found"; 

        if(location!=null) { 



            positionOverlay.setLocation(location);


            Double geoLat=location.getLatitude()*1E6;
            Double geoLng=location.getLongitude()*1E6;
            GeoPoint point=new GeoPoint(geoLat.intValue(),geoLng.intValue());

            mapController.animateTo(point);

        double lat = location.getLatitude(); 
        double lon = location.getLongitude(); 
        latLong = "Lat:" + lat + "\nLong:" + lon; 



        double lattitude = location.getLatitude(); 
        double longitude = location.getLongitude(); 

        Geocoder gc = new Geocoder(this,Locale.getDefault()); 
        try { 
        List<Address> addresses= gc.getFromLocation(lattitude, longitude, 1); 
        StringBuilder sb = new StringBuilder(); 
        if(addresses.size()>0) { 
        Address address=addresses.get(0);
        for(int i=0;i<address.getMaxAddressLineIndex();i++)
            sb.append(address.getAddressLine(i)).append("\n");
        sb.append(address.getLocality()).append("\n"); 
        sb.append(address.getPostalCode()).append("\n"); 
    sb.append(address.getCountryName()); 
    } 
        addressString = sb.toString(); 
        } 
        catch (Exception e) { 
        } 
        } else { 
        latLong = " NO Location Found "; 
        } 

        myLocation.setText("Current Position is :\n"+ latLong + "\n"+  addressString ); 
           }