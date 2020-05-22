public static CoordD getIntersection(CoordD point1, double bearing1, CoordD point2, double bearning2) {
    double lat1 = rad(point1.latitude); double lon1 = rad(point1.longitude);
    double lat2 = rad(point2.latitude); double lon2 = rad(point2.longitude);
    double bearing13 = rad(bearing1); double bearing 23 = rad(bearing2);
    double dLat = lat2 - lat1; double dLon = lon2 - lon1;

    double dist12 = 2 * Math.asin( Math.sqrt( Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2) ) );
    if (dist12 == 0) return null;

    double bearingA = Math.acos( ( Math.sin(lat2) - Math.sin(lat1) * Math.cos(dist12) ) /
        ( Math.sin(dist12) * Math.cos(lat1) ) );
    double bearingB = Math.acos( ( Math.sin(lat1) - Math.sin(lat2) * Math.cos(dist12) ) /
        ( Math.sin(dist12) * Math.cos(lat2) ) );
    if (Double.isNaN(bearingA)) bearingA = 0;
    if (Double.isNaN(bearingB)) bearingB = 0;

    double bearing12, bearing21;
    if (Math.sin(dLon) > 0) {
        bearing12 = bearingA;
        bearing21 = 2 * Math.PI - bearingB;
    } else { 
        bearing12 = 2 * Math.PI - bearingA;
        bearing21 = bearingB;
    }

    double alpha1 = (bearing13 - bearing12 + Math.PI) % (2 * Math.PI) - Math.PI; // Angle 2-1-3
    double alpha2 = (bearing21 - bearing23 + Math.PI) % (2 * Math.PI) - Math.PI; // Angle 1-2-3

    if (Math.sin(alpha1) == 0 && Math.sin(alpha2) == 0) return null; // Infinite intersections
    if (Math.sin(alpha1) * Math.sin(alpha2) < 0) return null; // Ambiguous intersection

    // needed?
    // alpha1 = Math.abs(alpha1);
    // alpha2 = Math.abs(alpha2);

    double alpha3 = Math.acos( -Math.cos(alpha1) * Math.cos(alpha2) +
        Math.sin(alpha1) * Math.sin(alpha2) * Math.cos(dist12) );
    double dist13 = Math.atan2( Math.sin(dist12) * Math.sin(alpha1) * Math.sin(alpha2),
        Math.cos(alpha2) + Math.cos(alpha1) * Math.cos(alpha3) );

    double lat3 = Math.asin( Math.sin(lat1) * Math.cos(dist13) +
        Math.cos(lat1) * Math.sin(dist13) * Math.cos(bearing13) );

    double dLon13 = Math.atan2( Math.sin(bearing13) * Math.sin(dist13) * Math.cos(lat1),
        Math.cos(dist13) - Math.sin(lat1) * Math.sin(lat3) );
    double lon3 = lon1 + dLon3;
    lon3 = (lon3 + 3 * Math.PI) % ( 2* Math.PI) - Math.PI // normalize to +/-180

    return new CoordD(deg(lat3), deg(lon3));
}