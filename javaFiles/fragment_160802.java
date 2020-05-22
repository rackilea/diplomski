Map.Entry<MyObject, Double> maxEntry = null;
for (Map.Entry<MyObject, Double> entry : map.entrySet()) {
  if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
    maxEntry = entry;
  }
}
MyObject maxKey = maxEntry.getKey();  // Might NPE if map is empty.