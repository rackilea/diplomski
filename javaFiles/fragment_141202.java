public List<List<Integer>> searchHops(int from, int to, Set<Integer> seen) {
    seen.add(from);

    if (from == to) {
        final List<List<Integer>> newList = new ArrayList<>();
        newList.add(new ArrayList<>(Arrays.asList(from)));
        return newList;
    }

    List<List<Integer>> allPaths = null;
    for (int neighbor : getNeighbors(from)) {
        if (!seen.contains(neighbor)) {
            List<List<Integer>> results = searchHops(neighbor, to, new HashSet<>(seen));

            if (results != null) {
                for(List<Integer> result : results) {
                    result.add(0, from);
                    if( allPaths != null )
                        allPaths.add(result);
                }
                if( allPaths == null )
                    allPaths = results;
            }
        }
    }
    return allPaths;
}