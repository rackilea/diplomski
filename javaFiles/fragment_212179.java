public static <T> T[] repeat(T[] arr, int newLength) {
  T[] dup = Arrays.copyOf(arr, newLength);
  for (long last = arr.length; last != 0 && last < newLength; last <<= 1) {
    System.arraycopy(dup, 0, dup, (int) last, (int) (Math.min(last << 1, newLength) - last));
  }
  return dup;
}