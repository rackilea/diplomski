// move all the method
double distanceFrom(WesternTown other){
    return Math.sqrt(Math.pow(this.location.getX() - other.location.getX(), 2) + 
                     Math.pow(this.location.getY() - other.location.getY(), 2));
}

// or just call the Geolocation method
double distanceFrom(WesternTown other){
    return this.location.distanceFrom(other.location);
}