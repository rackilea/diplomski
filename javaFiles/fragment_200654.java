Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
        mGoogleApiClient);

gcm = GoogleCloudMessaging.getInstance(this);
regid = getRegistrationId(context);
if (!regid.isEmpty() && mLastLocation != null) {
    double latitude = mLastLocation.getLatitude();
    double longitude = mLastLocation.getLongitude();
    PostData pd = new PostData();
    pd.execute(regid, String.valueOf(latitude), String.valueOf(longitude));
} else {
    //register if regid is empty
    if (regid.isEmpty()){
       registerInBackground();
    }
}