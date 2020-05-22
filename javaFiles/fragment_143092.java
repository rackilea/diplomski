Map<String, Set<String>> h = ...; // The map created in the OP

List<String> allAnagrams = new LinkedList<>();
for (Set<String> anagrams : h.values()) {
    allAnagrams.addAll(anagrams);
}