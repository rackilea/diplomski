double myCurrentLong;
double myCurrentLat;
//Fill those two variables somehow here
Location myCurrentLoc = new Location("My Current");
locationA.setLongitude(myCurrentLong);
myCurrentLoc.setLatitude(myCurrentLat);

List<Locations> myLocations = locationLibrary.getLocations();
Collections.sort(ls, new Comparator<Location>(){
  public int compare(Location l1, Location l2) {
    return l1.distanceTo(myCurrentLoc) - l2.distanceTo(myCurrentLoc);
  }
});