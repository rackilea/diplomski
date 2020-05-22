Set<Integer> adjacent = new HashSet<>();
Set<Integer> results = new HashSet<>();

for (Integer i: toCheck) {
   Set<Integer> check = adjacencyLists.get(i);
   for (Integer c: check)
      if (!adjacent.add(c)) {
         // Duplicate found
         results.add(c);
      }
}
return results;