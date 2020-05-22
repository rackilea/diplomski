FindPaths(G, v) {
  // The first path is, simply, the starting node.
  // It should be the first vertex in topological order.
  pending_paths = {(v)};
  while (pending_paths is not empty) {
    l = pending_paths.remove_first(); // pop the first pending path
    output(l); // output it (or save it in a list to be returned, if you prefer)
    v = back(l); // Get the last vertex of the path
    foreach(edge (v, v') in G) { // For each edge outgoing from v'...
      // extend l with v' and put into the list of paths to be examined.
      pending_paths.push_back(extend(l, v'));
    } 
  }
}