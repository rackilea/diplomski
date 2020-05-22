private boolean isPointInPolygon(Geopoint tap, ArrayList<Geopoint> vertices) {
    int intersectCount = 0;
    for(int j=0; j<vertices.size()-1; j++) {
        if( rayCastIntersect(tap, vertices.get(j), vertices.get(j+1)) ) {
            intersectCount++;
        }
    }

    return (intersectCount%2) == 1); // odd = inside, even = outside;
}

private boolean rayCastIntersect(Geopoint tap, Geopoint vertA, Geopoint vertB) {

    double aY = vertA.getLatitude();
    double bY = vertB.getLatitude();
    double aX = vertA.getLongitude();
    double bX = vertB.getLongitude();
    double pY = tap.getLatitude();
    double pX = tap.getLongitude();

    if ( (aY>pY && bY>pY) || (aY<pY && bY<pY) || (aX<pX && bX<pX) ) {
        return false; // a and b can't both be above or below pt.y, and a or b must be east of pt.x
    }

    double m = (aY-bY) / (aX-bX);               // Rise over run
    double bee = (-aX) * m + aY;                // y = mx + b
    double x = (pY - bee) / m;                  // algebra is neat!

    return x > pX;
}