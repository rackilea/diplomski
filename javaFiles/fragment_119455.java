ArrayList<Integer> positions = new ArrayList<Integer>(map.get(key));
for (int i = 0; i < positions.size(); i ++) {
  // updating list
  for (int j = i; i < positions.size(); j ++) {
    positions.set(j, positions.get(i) + diff);
  }
}