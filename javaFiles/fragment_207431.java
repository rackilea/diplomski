private HandlerThread mLocThread;
private void initThread(){
    mLocThread = new HandlerThread("locationThread");
    mLocThread.start();
}

private void requestLocUpdates(){
    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, 
    locationRequest, this, mLocThread.getLooper());
}

@Override
public void onLocationChanged(Location location) {
    // locationThread thread
}