public static class BNLSortComparator extends Text.Comparator {
  public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
    String sb1, sb2;
    try {
      sb1 = Text.decode(b1, s1, l1);
      ...