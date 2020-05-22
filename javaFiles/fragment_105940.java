...
Geocoder geocoder = new Geocoder(this, Locale.getDefault());
List<Address> addresses = null;

...
addresses = geocoder.getFromLocation(
            Latitude,    // <-- your Latitude = String.valueOf(lat);
            Longitude,   // <- your Longitude= String.valueOf(lng);
            location.getLongitude(),
            // In this sample, get just a single address.
            1);

// Handle case where no address was found.
if (addresses == null || addresses.size()  == 0) {
    if (errorMessage.isEmpty()) {
        errorMessage = getString(R.string.no_address_found);
        Log.e(TAG, errorMessage);
    }
    deliverResultToReceiver(Constants.FAILURE_RESULT, errorMessage);
} else {
    Address address = addresses.get(0);
    ArrayList<String> addressFragments = new ArrayList<String>();

    // Fetch the address lines using getAddressLine,
    // join them, and send them to the thread.
    for(int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
        addressFragments.add(address.getAddressLine(i));
    }
}
...