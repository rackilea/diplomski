public static boolean isBetween(int x, int lower, int upper) {
  return lower <= x && x <= upper;
}

if (isBetween(num, 1, 5)) {
  System.out.println("testing case 1 to 5");
} else if (isBetween(num, 6, 10)) {
  System.out.println("testing case 6 to 10");
}