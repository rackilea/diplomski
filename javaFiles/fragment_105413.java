SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);

location_switch = (MaterialAnimatedSwitch)findViewById(R.id.location_switch);

// Set the status of the switch from shared preferences
location_switch.setChecked(sharedPreferences.getBoolean("location_switch_state", false));

location_switch.setOnCheckedChangeListener(new MaterialAnimatedSwitch.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(boolean isChecked) {

        // Save the switch status in shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("location_switch_state", isChecked);
        editor.apply();

        if(isChecked){
            FirebaseDatabase.getInstance().goOnline();
            startLocationUpdates();
            displayLocation();
            Snackbar.make(mapFragment.getView(),"You are online", Snackbar.LENGTH_SHORT).show();
        }else{

            FirebaseDatabase.getInstance().goOffline();
            stopLocationUpdates();
            mCurrent.remove();
            mMap.clear();
            handler.removeCallbacks(drawPathRunnable);
            Snackbar.make(mapFragment.getView(),"You are offline", Snackbar.LENGTH_SHORT).show();
        }
    }
});