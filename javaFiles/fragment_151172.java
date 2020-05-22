List<List<Integer>> toLists(Map<Set<Point>> adjacencies) {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  for (Point pt : adjacencies.getKeys()) {
    List<Integer> adjs = new ArrayList<Integer>();
    adjs.add(pt.getX());
    adjs.add(pt.getY());
    adjs.add(0);
    for (Point adjPt : adjacencies.get(pt)) {
      adjs.add(adjPt.getX());
      adjs.add(adjPt.getY());
      adjs.add(0);
    }
    result.add(adjs);
  }
  return result; 
}