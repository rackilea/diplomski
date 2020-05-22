List<Map.Entry<String, Double>> sorted = new ArrayList<>(population.entrySet());
// sort by fitness
Collections.sort(sorted, Comparator.comparing(Map.Entry::getValue));

Set<Integer> usedIndices = new HashSet<>(); // keep track of used indices
Map<String, Double> result = new HashMap<>();
while (result.size() < sorted.size()/2) {
    int index = rnd.nextInt(sorted.size());
    if (!usedIndices.add(index)) {
        continue; // was already used
    }
    Map.Entry<String,Double> survivor = sorted.get(index);
    result.put(survivor.getKey(), survivor.getValue());
}
return result;