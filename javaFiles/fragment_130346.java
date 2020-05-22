Criteria criteria = new Criteria();
    LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
    String provider = locationManager.getBestProvider(criteria, false);
    Location location = locationManager.getLastKnownLocation(provider);
    double lat =  location.getLatitude();
    double lng = location.getLongitude();
    LatLng coordinate = new LatLng(lat, lng);
    CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 13);
    mMap.animateCamera(yourLocation);