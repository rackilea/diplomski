Location location = locManager.getLastKnownLocation(provider);
if (location == null){
    //handle this case
    //return location with some default coordinates, for example
}
return location;