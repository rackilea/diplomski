public void updateCamera(float bearing) {
            CameraPosition currentPlace = new CameraPosition.Builder()
                    .target(new LatLng(centerLatitude, centerLongitude))
                    .bearing(bearing).tilt(65.5f).zoom(18f).build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(currentPlace));

    }