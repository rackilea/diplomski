private List<Integer> searchHops(int from, int to, List<Integer> seen) {
  seen.add(from);
  if( from == to )
    return new ArrayList<Integer>(Arrays.asList(from));
  for(int neighbor : getNeighbors(from) )
    if( !seen.contains(neighbor) ) {
      List<Integer> result = searchHops(neighbor, to, seen);
      if(result != null) {
        result.add(0, from);
        return result;
      }
    }
  return null;
}

//actual entry point
public List<Integer> searchHops(int from, int to) {
    return searchHops(from, to, new ArrayList<Integer>());
}