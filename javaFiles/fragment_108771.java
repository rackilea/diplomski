public void onFindPathClick(View view) {
String originAddress = OriginPlaceFragment.mAutoPlaceSearch.getText().toString();
String destinationAddress = DestinationPlaceFragment.mAutoPlaceSearch.getText().toString();

Intent intent = new Intent(SimpleTabsActivity.this, MapsActivity.class);
if (!originAddress.toString().isEmpty() && !destinationAddress.toString().isEmpty()) {
    intent.putExtra(ORIGIN_ADDRESS, originAddress);
    intent.putExtra(DESTIN_ADDRESS, destinationAddress);
    startActivity(intent);
} else {
    Toast.makeText(this, "Fill \"from\" and \"to\" fields", Toast.LENGTH_SHORT).show();
}
}