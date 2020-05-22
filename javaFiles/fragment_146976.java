public static <T> void sort(Collection<T> c, Comparator<? super T>... cmps) {
  Collections.sort(c, new Comparator<T>() {
    public int compare(T a, T b) {
      for (int i = cmps.length; --i >= 0;) {
        int delta = cmps[i].compare(a, b);
        if (delta != 0) { return delta; }
      }
      return 0;
    }
  });
}