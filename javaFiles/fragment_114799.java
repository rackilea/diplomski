public static long[] floorAndRemainder(long a, long b) {
  long floor = a / b;
  long remainder = a % b;
  boolean isNegative = a < 0 ^ b < 0;
  boolean hasRemainder = remainder != 0;

  // Correct the floor.
  if (isNegative && hasRemainder) {
    floor--;
  }

  // Correct the remainder.
  if (hasRemainder) {
    if (isNegative) {
      if (a < 0) { // then remainder < 0 and b > 0
        remainder += b;
      } else { // then remainder > 0 and b < 0
        remainder = -remainder - b;
      }
    } else {
      if (remainder < 0) {
        remainder = -remainder;
      }
    }
  }
  return new long[] { floor, remainder };
}