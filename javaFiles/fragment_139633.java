public class myLocationListner implements LocationListener{

    Geocoder mGeocoder;

    // default constructor
    myLocationListener() {
        // instantiate geocoder object:
        mGeocoder = new Geocoder(this, Locale.getDefault());
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null){

            double gettextLong = location.getLongitude();
            double gettextLat = location.getLatitude();

            textLat.setText(Double.toString(gettextLat));
            textLong.setText(Double.toString(gettextLong));

            List<Address> addresses = mGeocoder.getFromLocation(gettextLat, getTextLong, 1);

        }
   }