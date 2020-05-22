// modify current instance
void shiftCoordinate(double z, double w) {
    this.x = x + z;
    this.y = y + w;
}

// return a new object
Coordinate shiftCoordinate(double z, double w) {
    return new Coordinate(this.x + z, this.y + w);
}