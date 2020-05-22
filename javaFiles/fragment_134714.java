for (int i = 0; i < neighbours.size(); i++) {
  Node n = neighbours.get(i);
  int mf = neighbours.size();

  if (n != null && !n.visited) {
    n.parent = element.data;
    queue.add(n);
    n.visited = true;
    n.height = element.height + 1;    // <- this is right
  }

  // This was wrong
  //n.height++;                    
  //element.height = n.height;
}