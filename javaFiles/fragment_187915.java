public static final double KNOTS_PER_MPS = 1.9438444924406;
public static final double MPS_PER_KNOT = 0.514444444444444;


public static double metersPerSecondToKnots(double speedInMetersPerSecond) {
    return speedInMetersPerSecond * KNOTS_PER_MPS;
}

public static double knotsToMetersPerSecond(double speedInKnots) {
    return speedInKnots * MPS_PER_KNOT;
}

public static double courseInDegreesToAzimuth(double courseInDegrees) {
    Validate.isTrue(courseInDegrees >= 0.0 && courseInDegrees <= 360.0);
    double azimuth;
    if (courseInDegrees > 180.0) {
        azimuth = -180.0 + (courseInDegrees - 180.0);
    } else {
        azimuth = courseInDegrees;
    }
    return azimuth;
}

public static double azimuthToCourseInDegrees(double azimuth) {
    Validate.isTrue(azimuth >= -180.0 && azimuth <= 180.0);
    double courseInDegrees;
    if (azimuth < 0.0) {
        courseInDegrees = 360.0 + azimuth;
    } else {
        courseInDegrees = azimuth;
    }
    return courseInDegrees;
}