A[][] a = ...;
merge(a, new Comparator<A[]>() {
  int compare(A[] a, A[] b) {
    return ((Float)a[0]) - ((Float)b[0]);
  }
});