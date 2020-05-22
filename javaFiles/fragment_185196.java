Set<Integer> adjacent = new HashSet<>();

for (Integer i: toCheck) {
   int oldCount = adjacent.size();
   Set<Integer> check = adjacencyLists.get(i);
   adjacent.addAll(check);
   if (adjacent.size() != oldCount+check.size()) {
      // Duplicate found
      return true;
   }
}
return false;