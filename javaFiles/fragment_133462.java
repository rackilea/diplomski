private static List<Entry<String, Integer>> getEntriesWithTopValues(Map<String, Integer> map, Set<Integer> topValues) {
  List<Entry<String, Integer>> result = new ArrayList<> ();
  for (Entry<String, Integer> e : map.entrySet()) {
    if (topValues.contains(e.getValue())) result.add(e);
  }

  Collections.sort(result, new Comparator<Entry<String, Integer>>() {
    @Override
    public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
      return e1.getValue().compareTo(e2.getValue());
    }
  });

  return result;
}