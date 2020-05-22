Iterator<int[]> permutations(final int[]... conditions) {
  int productLengths = 1;
  for (int[] arr : conditions) { productLengths *= arr.length; }
  final int nPermutations = productLengths;
  return new Iterator<int[]>() {
    int index = 0;
    public boolean hasNext() { return index < nPermutations; }
    public int[] next() {
      if (index == nPermutations) { throw new NoSuchElementException(); }
      int[] out = new int[conditions.length];
      for (int i = out.length, x = index; --i >= 0;) {
        int[] arr = conditions[i];
        out[i] = arr[x % arr.length];
        x /= arr.length;
      }
      ++index;
      return out;
    }
    public void remove() { throw new UnsupportedOperationException(); }
  };
}