Set<List<String>> setOfList = Set.of(List.of("1"));
print2(setOfList); // pretend it works...

for (List<String> list : setOfList) {
  String s = list.get(0);  // ClassCastException, it's a CharBuffer.
}