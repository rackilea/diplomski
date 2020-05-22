PriorityQueue<Map.Entry<String, Integer>> pq = 
  new PriorityQueue<Map.Entry<String, Integer>>(
    20, new Comparator<Map.Entry<String, Integer>() {
      @Override public int compare(
          Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e2.getValue().compareTo(e1.getValue());
        // not the other way around, since we want the maximum values
      }
    });
for (Map.Entry<String, Integer> entry : map.entrySet()) {
  pq.add(entry);
  if (pq.size() > 20) {
    pq.remove();
  }
}
while (!pq.isEmpty()) {
  Map.Entry<String, Integer> entry = pq.remove();
  System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
}