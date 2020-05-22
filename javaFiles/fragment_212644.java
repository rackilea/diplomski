if (addresses != null && addresses.size() > 0) {
    String address = addresses.get(0).getAddressLine(0);
    String city = addresses.get(0).getLocality();
    String state = addresses.get(0).getAdminArea();
    String country = addresses.get(0).getCountryName();
    String postalCode = addresses.get(0).getPostalCode();
    String knownName = addresses.get(0).getFeatureName();

    mProgressDialog.dismiss();
    TextView cellText = (TextView) findViewById(R.id.cellText);
    cellText.setText(address);

} else {
    mProgressDialog.dismiss();
    TextView cellText = (TextView) findViewById(R.id.cellText);
    cellText.setText("Error");
}