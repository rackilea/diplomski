for (int x = 0; x < graph.length; x++) {
  Integer freq = map.get(x);
  int f = freq == null ? 0 : freq;
  for (int y = 0; y < graph[x].length; y++) {
     graph[x][y] = y == f ? '*' : ' ';
  }
}