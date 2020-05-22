protected void onStop() {
  if(!fromOnMapReady){
    mGoogleApiClient.disconnect();
  }
  super.onStop();
}