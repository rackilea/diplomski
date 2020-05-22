for (Entry<Integer, Integer> entry : map.entrySet()) {
  int index = entry.getKey();
  int frequency = entry.getValue();
  if (frequency < graph.length && index < graph[frequency].length) {
    graph[frequency][index] = '*'; 
  }
}