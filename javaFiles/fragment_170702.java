public LocationContent(String name, double latitude, double longitude) {
    Name = name;
    Latitude = latitude;
    Longitude = longitude;
}

public LocationContent(){

}

public String getName() {
    return Name;
}

public void setName(String name) {
    Name = name;
}

public double getLatitude() {
    return Latitude;
}

public void setLatitude(double latitude) {
    Latitude = latitude;
}

public double getLongitude() {
    return Longitude;
}

public void setLongitude(double longitude) {
    Longitude = longitude;
}