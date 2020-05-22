private void setUpMap(String address) throws IOException {
        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(address, 1);
        Address add = list.get(0);
        double Longitude = add.getLongitude();
        double Latitude= add.getLatitude();
        Marker m = mMap.addMarker(new MarkerOptions().position(new LatLng(Latitude, Longitude)).title(address));

        //not needed:
        //LatLngBounds.Builder builder = new LatLngBounds.Builder();
        //builder.include(m.getPosition());
        //LatLngBounds bounds = builder.build();
        //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 10));

        //use CameraPosition instead:
        LatLng latLng = new LatLng(Latitude, Longitude);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng).zoom(14).build();

        //use animateCamera instead of moveCamera:
        mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }