if (listOne.size() == 1) {
  List<String> mergedStrings = new ArrayList<>();
  mergedStrings = ... merge the ONE listOne entry with all listTwo entries
  Set<List<String>> rv = new HashSet<>();
  rv.add(mergedStrings);
  return rv;
}