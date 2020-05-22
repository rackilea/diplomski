stopLocationButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        locationManager.removeUpdates(locationListener)  ;       
    }
});