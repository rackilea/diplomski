WesternTown dodgeCity = new WesternTown(7, 2, 29, new GeoLocation(37.765469, 100.015167));
WesternTown durango = new WesternTown(4, 0, 6, new GeoLocation(37.275280, 107.880066));

// 1. Leave method in GeoLocation class
double distance = dodgeCity.getLocation().distanceFrom(durango.getLocation());
// 2. or move it into WesternTown
double distance = dodgeCity.distanceFrom(durango);