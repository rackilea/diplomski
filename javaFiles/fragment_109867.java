locOpts.addOptionsChangedListener(new OptionsChangedListener() {
    @Override
    public void optionsChanged(OptionsChangedEvent event) {
        Log.d("LOCATION_OPTIONS_CHANGED", "SUCCESS");
        mLocationManager.removeUpdates(mLocationListener);
        mLocationManager.requestLocationUpdates(
                provider,
                update,
                0, mLocationListener,
                Looper.getMainLooper() // this was the problem

        );
    }
});