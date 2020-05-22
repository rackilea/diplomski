public LatLng getLocationFromAddress(Context context, String strAddress) {
    LatLng latLng = null;
    try {
        Geocoder coder = new Geocoder(context, Locale.getDefault());
        List<Address> address = coder.getFromLocationName(strAddress, 1);
        // will only iterate through address list when the geocoder was successful
        for(Address a : address){
            latLng = new LatLng(a.getLatitude, a.getLongitude);
            Log.e(TAG, "Country Name = " + a.getCountryName());
        }
    } catch (Exception e) {
        //Log that error!
        Log.e(TAG, e.getMessage());
    }
    //will return null if an address was not found
    return latLng;
}