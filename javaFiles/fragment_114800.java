public static long[] floorAndRemainder(long a, long b) {
  long floor = a / b;
  if ((a < 0 ^ b < 0) && a % b != 0) {
    floor--;
  }
  long remainder = Math.abs(a - floor * b);
  return new long[] { floor, remainder };
}