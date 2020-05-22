public String getUserLocation() {

    String address = "";

    LocationManager locManager = (LocationManager) context
            .getSystemService(Context.LOCATION_SERVICE);

    boolean network_enabled = locManager
            .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    Location location;

    if (network_enabled) {

        location = locManager
                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();

            Log.e("longitude  = ", longitude + "lat");
            Log.e("latitude  = ", latitude + "long");

            Geocoder gcd = new Geocoder(context, Locale.getDefault());
            List<Address> addresses = null;
            try {
                addresses = gcd.getFromLocation(latitude, longitude, 1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return address;
            }
            if (addresses.size() > 0) {

                String addressline = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getAddressLine(1);
                String country = addresses.get(0).getAddressLine(2);

                Log.e("Address", addressline + ", " + city + ", " + country);
                return address = addressline + ", " + city + ", " + country;
            }

            return address;
        }
    }

    return address;

}