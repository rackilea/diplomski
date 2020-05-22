public void onViewCreated(View view, Bundle savedInstanceState){
    googleAnalyticsSendScreen();

    // Getting Google Play availability status
    int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity().getBaseContext());

    if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available

        int requestCode = 10;
        Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, getActivity(), requestCode);
        dialog.show();

    } else { // Google Play Services are available

        getAllDataFromParse();
        setUpMap();

        mGoogleMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        mGoogleMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        Boolean isGPSProviderEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        Boolean isNetworkProviderEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        //TOOLBARS Disabled.
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);


        if (isNetworkProviderEnabled){
            location =  locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            defaultLocation = mGoogleMap.getMyLocation();}

            if (isGPSProviderEnabled){
                location =  locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        defaultLocation = mGoogleMap.getMyLocation();}
           else {

                if (mMyMarkersArray.isEmpty()){

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.location_error_title);
                builder.setMessage(R.string.location_error_message);
                builder.setPositiveButton(android.R.string.ok, null);

                AlertDialog dialog = builder.create();
                dialog.show();}
          }

          if (defaultLocation != null) {
              onLocationChanged(defaultLocation);
              latLng = new LatLng(lat, lng);
              mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

    }
   //Location yoksa default value ve zoom value ile yaratıyor.
   /* else if (defaultLocation != null){
        onLocationChanged(defaultLocation);

        latLng = new LatLng(lat, lng);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));}*/

            else{
                latLng = new LatLng(41.048846, 29.027924);
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 11));
        }
    }

}