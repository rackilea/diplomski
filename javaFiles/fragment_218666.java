// Get the last known location from all providers
// return best reading is as accurate as minAccuracy and
// was taken no longer then minTime milliseconds ago

private Location bestLastKnownLocation(float minAccuracy, long minTime) {
    mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    Location bestResult = null;
    float bestAccuracy = Float.MAX_VALUE;
    long bestTime = Long.MIN_VALUE;

    List<String> matchingProviders = mLocationManager.getAllProviders();

    for (String provider : matchingProviders) {

        Location location = mLocationManager.getLastKnownLocation(provider);

        if (location != null) {

            float accuracy = location.getAccuracy();
            long time = location.getTime();

            if (accuracy < bestAccuracy) {

                bestResult = location;
                bestAccuracy = accuracy;
                bestTime = time;

            }
        }
    }

    // Return best reading or null
    if (bestAccuracy > minAccuracy || bestTime < minTime) {
        return null;
    } else {
        return bestResult;
    }
}