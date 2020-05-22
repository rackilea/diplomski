public void onLocationChanged(Location location) {
    Location temp = mCurrentLocation;     //save the old location      
    mCurrentLocation = location;          //get the new location
    distance = mCurrentLocation.distanceTo(temp);   //find the distance     
    updateUI();
}