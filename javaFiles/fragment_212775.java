/* Compute the components of the vector from o to l. */
double diffX = l.getX() - o.getX();
double diffY = l.getY() - o.getY();
double diffZ = l.getZ() - o.getZ();

/* Find the horizontal distance from o to l (assuming that
   Y is the vertical direction. */
double distXZ = Math.hypot(diffX, diffZ);

/* Compute the angle in degrees using the vertical distance
   and the horizontal distance. */
double pitch = Math.toDegrees(Math.atan2(diffY, distXZ));