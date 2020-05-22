private Map<String, List<String>> reverseMap(Map<String, List<String>> adjList) {
    Map<String, List<String>> tGraph = new HashMap<>();
    for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
        for (String value : entry.getValue()) {
            List<String> newValues = tGraph.get(value);
            if (newValues == null) {
                newValues = new ArrayList<>();
                tGraph.put(value, newValues);
            }
            newValues.add(entry.getKey());
        }
    }
    return tGraph;
}