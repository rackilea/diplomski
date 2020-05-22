if(lastKnownLocation != null)
{
           LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());

            mMap.clear();

            mMap.addMarker(new MarkerOptions().position(userLocation).title("My Location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
}