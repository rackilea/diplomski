private  Map<String, List<String>> reverseMap(Map<String, List<String>> adjList) {
    Map<String, List<String>> tGraph = new HashMap<>();
    for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
        for (String value : entry.getValue()) {
            tGraph.computeIfAbsent(value, v -> new ArrayList<>()).add(entry.getKey()); // Updated according comment from @shmosel
        }
    }
    return tGraph;
}