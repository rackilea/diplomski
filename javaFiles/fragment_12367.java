LocationManager locationManager = context.getSystemService(Context.LOCATION_SERVICE);
String provider = LocationManager.GPS_PROVIDER;
Location lastKnownLocation = locationManager.getLastKnownLocation(provider);

if (null != lastKnownLocation) {
    Toast.makeText(getActivity().getApplicationContext(),String.valueOf(lastKnownLoc‌​ation.getLatitude() + lastKnownLocation.getLongitude() ),Toast.LENGTH_SHORT).show();
}