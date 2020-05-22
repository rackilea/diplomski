float[] results = new float[1];
Location.distanceBetween(currentlatitude, currentlongitude, originLat, originLon, results);
float distanceInMeters = results[0];
boolean isWithinRange = distanceInMeters < 3000; 

if (isWithinRange) {
    //write your code what ever you wanna perform
}