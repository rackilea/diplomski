public void test() {
  List<String> aList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "a"));
  List<String> bList = new ArrayList<>(Arrays.asList("b", "d", "e", "c", "a"));
  List<String> cList = new ArrayList<>(Arrays.asList("c", "f", "a"));
  // Not in all lists.
  List<String> inAll = new ArrayList<>(aList);
  inAll.retainAll(bList);
  inAll.retainAll(cList);
  // Unique results - all items in all lists.
  Set<String> result = new HashSet<>(aList);
  result.addAll(bList);
  result.addAll(cList);
  // But nothing that is in all lists.
  result.removeAll(inAll);
  System.out.println(result);
}