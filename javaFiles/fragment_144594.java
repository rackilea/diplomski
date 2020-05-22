int search(List<? extends T> xs, final T x) {
    return search(xs, x, new Comparator<T>() {
      @Override
      public int compare(T o1, T o2) {
        return x.compareTo(o2);
      }
    });
}