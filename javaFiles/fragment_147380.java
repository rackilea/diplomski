private volatile Set<Integer> indexesToRemove =
  Collections.synchronizedSet(new TreeSet<Integer>(
    new Comparator<Integer>() {
      @Override public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1); // sort descending for later element removal
      }
    }
  ));