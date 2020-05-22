@Override
    public void onMapReady(GoogleMap googleMap) {
        gMap= googleMap;
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //Create MarkerOptions
                MarkerOptions markerOptions = new MarkerOptions().position(latLng);
                //Create Marker
                Marker marker = gMap.addMarker(markerOptions);
                //Add Latlng and Marker
                latLngList.add(latLng);
                markerList.add(marker);

                polylineOptions = new PolylineOptions().addAll(latLngList).clickable(true);
            }
        });
    }