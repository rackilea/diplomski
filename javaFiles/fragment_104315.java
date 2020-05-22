@Override
    public void onProviderDisabled(String provider) {
        // Called when the provider is disabled by the user. If requestLocationUpdates is called on an already disabled provider, this method is called immediately.

    }

@Override
public void onProviderEnabled(String provider) {
    // Called when the provider is enabled by the user.

}



@Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Called when the provider status changes. This method is called when a provider is unable to fetch a location or if the provider has recently become available after a period of unavailability.

    }