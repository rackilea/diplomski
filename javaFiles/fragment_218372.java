Location currentLocation = new Location();     
currentLocation.setLatitude(CURRENT_USER_LAT); 
currentLocation.setLongitude(CURRENT_USER_LNG);
Location compareLoc = new Location();
float minDist = Float.MAX_VALUE;
float distance = Float.MAX_VALUE;
for(int i=0; i<TOTAL_LOCATIONS; i++)
{
    compareLoc.setLatitude(LOCATIONS[i].lat); 
    compareLoc.setLongitude(LOCATIONS[i].lng);
    distance = currentLocation.distanceTo(compareLoc);
    if(distance<minDist) {
        //THIS IS THE ENTRY WITH THE MINIMUM DISTANCE.
        //DO WITH IT AS YOU PLEASE
    }
}