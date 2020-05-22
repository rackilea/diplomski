boolean isValid(Point p) {
    return p == null || (p.x >= 0 && p.y >= 0);
}

boolean isValid(Coordinate c) {
    return isValid(c.mapCoordinates)
        && isValid(c.tileSetCoordinates) 
        && isValid(c.tileCoordinates) 
        && isValid(c.pixelCoordinates);
}