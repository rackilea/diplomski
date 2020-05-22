// Retrieve the ConnectivityManager via the current Context
ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

// Create the method to be called when the WiFi network changes
ConnectivityManager.NetworkCallback callback = new ConnectivityManager.NetworkCallback() {
    @Override
    public void onAvailable(Network network) {
        // Check that this Network is the correct one and take
        // action as appropriate
    }
};

// Set the callback to be fired when WiFi status changes
cm.registerNetworkCallback(
     new NetworkRequest.Builder()
     .addTransportType(TRANSPORT_WIFI)
     .build(),
     callback
);