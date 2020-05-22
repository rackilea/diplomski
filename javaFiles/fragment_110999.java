// Getting Google Play availability status
int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());


//there are other "status" values as well, you can check according to your need

// Showing status
if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available

    int requestCode = 10;
    ialog dialog = GooglePlayServicesUtil.getErrorDialog(status, getActivity(), requestCode);
    dialog.show();

}else{ // Google Play Services are available 

    // get map and play with it
}