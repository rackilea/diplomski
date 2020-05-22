private Map<String, ArrayList<String>> reverseAdjList(Map<String, List<String>> adjList) {
    Map<String, ArrayList<String>> tGraph = new HashMap<>();
    for (Map.Entry<String, List<String>> entry : adjList.entrySet())  {
        String key = entry.getKey();
        List<String> value = entry.getValue();
        for (String v : value) {
            ArrayList<String> values = new ArrayList<>();
            values.add(key);
            if (tGraph.containsKey(v)) {
                values.addAll(tGraph.get(v));
            }
            tGraph.put(v, values);
        }
    }
    return tGraph;
}