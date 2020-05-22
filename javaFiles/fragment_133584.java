private void getLastLocation() {
    try {
        fusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            mLocation = task.getResult();
                            location("MY_PHONE_NUMBER", task.getResult());
                        } else {
                            Log.w(TAG, "Failed to get location.");
                        }
                    }
                });
    } catch (SecurityException unlikely) {
        Log.e(TAG, "Lost location permission." + unlikely);
    }
}