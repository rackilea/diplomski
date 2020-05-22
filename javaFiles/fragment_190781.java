public static Address getAddressForLatLng(final Context context, final LatLng location) {
    final int MAX_RESULTS = 1;
    final Geocoder geocoder = new Geocoder(context, Locale.getDefault());
    Address address = new Address(Locale.getDefault());
    try {
        final List<Address> addresses = geocoder.getFromLocation(location.latitude, location.longitude, MAX_RESULTS);
        if (addresses != null && addresses.size() != 0) {
            address = addresses.get(0);
        }
        return address;
    } catch (IOException e) {
        Log.e("Geocoding", "Geocoding was not possible");
    }
    return address;
}