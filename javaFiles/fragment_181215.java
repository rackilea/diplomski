public static double calFeetAndInchesToCentimeters (double inches) {
if (inches <0) {
  throw new IllegalArgumentException("inches must be non-negative");
} else {
  return (inches/12);
}