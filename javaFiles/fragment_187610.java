else {
    //If everything went fine lets get latitude and longitude
    currentLatitude = location.getLatitude();   //change
    currentLongitude = location.getLongitude();

    Toast.makeText(this, currentLatitude + " WORKS " + currentLongitude + "", Toast.LENGTH_LONG).show();
}
yourAddresses= geocoder.getFromLocation(currentLatitude,currentLongitude, 1);