Intent intent = getIntent();

        if(intent.hasExtra("LatLng")){
            mLatLng = intent.getParcelableExtra("LatLng");

        }


public void onMapReady(){          
    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(mLatLng));
}