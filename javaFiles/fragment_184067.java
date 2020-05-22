int isGooglePlayServiceAvilable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
if (isGooglePlayServiceAvilable == ConnectionResult.SUCCESS) {
    beginUserInitiatedSignIn();
} else {
    GooglePlayServicesUtil.getErrorDialog(isGooglePlayServiceAvilable, MainMenu.this, REQUEST_DIALOG).show();
}