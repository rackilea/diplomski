map = mapView.getMap();
    map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            Latitude= location.getLatitude();
            Longitude=  location.getLongitude();
            Location locationzoom = map.getMyLocation();
            LatLng mapCenter = new LatLng(location.getLatitude(), location.getLongitude());
            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(mapCenter)
                    .zoom(13)
                    .build();
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                    2000, null);