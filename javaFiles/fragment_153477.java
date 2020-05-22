@Override
public void onConnected(@Nullable Bundle bundle) {

   Log.d("isj","connected");
}

@Override
public void onConnectionSuspended(int i) {

    Log.d("isj","connection susspended");
}

@Override
public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    Log.d("isj","connection failed");
}