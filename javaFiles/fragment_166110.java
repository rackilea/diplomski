public static boolean isBetween(int x, int lower, int upper) {
  return lower <= x && x <= upper;
}

if (isBetween(num, 0, 1000)) {

  // do something

} else if (isBetween(num, 1001, 2000)) {

// do domething

}
...