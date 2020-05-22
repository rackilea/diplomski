List<Address> addresses = mGeocoder.getFromLocation(gettextLat, gettextLong, 1);
if (addresses.size() > 0) {
    Log.e("TAG", addresses.get(0).getAddressLine(0)
            + addresses.get(0).getAddressLine(1)
            + addresses.get(0).getAddressLine(2));
    String myAddress = addresses.get(0).getAddressLine(0)
            + addresses.get(0).getAddressLine(1)
            + addresses.get(0).getAddressLine(2);
    textAddresss.setText(myAddress);
}