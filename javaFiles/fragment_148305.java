// center of square
double latitudeCenter = ...;     // in degrees
double longitudeCenter = ...;    // in degrees

double radius = ...;             // in km
double RADIUS_EARTH = 6371;      // in km

// north-east corner of square
double latitudeNE  = latitudeCenter  + Math.toDegrees(radius / RADIUS_EARTH);
double longitudeNE = longitudeCenter + Math.toDegrees(radius / RADIUS_EARTH / Math.cos(Math.toRadians(latitudeCenter)));

// south-west corner of square
double latitudeSW  = latitudeCenter  - Math.toDegrees(radius / RADIUS_EARTH);
double longitudeSW = longitudeCenter - Math.toDegrees(radius / RADIUS_EARTH / Math.cos(Math.toRadians(latitudeCenter)));