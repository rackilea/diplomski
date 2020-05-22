public boolean isGooglePlayServicesAvailable(Activity activity) {
    GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
    int status = googleApiAvailability.isGooglePlayServicesAvailable(activity);
    if(status != ConnectionResult.SUCCESS) {
        if(googleApiAvailability.isUserResolvableError(status)) {
              googleApiAvailability.getErrorDialog(activity, status, 1000).show();
        }
        return false;
    }
    return true;
}