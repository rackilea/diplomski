public List<Integer> findOdd(List<Integer> in) {
  List<Integer> ret = new ArrayList<Integer>();
  for (Integer i : in) {
    if (i % 2 == 1) {
      ret.add(i);
    }
  }
  return ret;
}