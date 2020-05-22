final TreeMap<Integer, TreeSet<String>> returnMap = new TreeMap<Integer, TreeSet<String>>();

final List<String> strings = new ArrayList();
for (final TreeSet<String> treeSet : returnMap.values()) {
  strings.addAll(treeSet);
}

final Iterator<String> mapItr = strings.iterator();