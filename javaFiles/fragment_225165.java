public static <V> List<String> genPairs(Collection<V> col) {
  List<V> ls = ImmutableList.copyOf(col);
  List<String> ret = new ArrayList<>();

  for (int i = 0; i < ls.size()-1; i++) {
    for (int j = i+1; j < ls.size(); j++) {
      ret.add(ls.get(i)+", "+ls.get(j));
    }
  }

  return ret;
}