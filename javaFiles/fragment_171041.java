public static <T extends Comparable<? super T>>
boolean isBigger(T x, T y) {
  return x != null && (y == null || x.compareTo(y) > 0);
}

public static <T>
boolean isBigger(T x, T y, Comparator<? super T> cmp) {
  return cmp.compare(x, y) > 0;
}