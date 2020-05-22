Map<Double, SortedSet<Integer>> map =
    new HashMap<Double, SortedSet<Integer>>();
for(int i = 0; i < scores.length; i++) {
    if(!map.containsKey(scores[i])) {
        map.puts(scores[i], new TreeSet<Integer>());
    }
    map.get(scores[i]).add(indexes[i] + 1);
}