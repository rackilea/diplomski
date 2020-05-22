LatLng biss = new LatLng(45.758035, 21.227514);
    mMap1.addMarker(new MarkerOptions()
            .position(biss)
            .title("Church")
            .snippet("gafhha")
            .icon(BitmapDescriptorFactory. fromResource(R.drawable.marker)));
    mMap1.moveCamera(CameraUpdateFactory.newLatLngZoom(biss, 14));