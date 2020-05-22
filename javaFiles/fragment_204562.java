private static int longestPath(Map<String, List<String>> tree) {
    return longestPath("start", tree, 0, 0);
}

private static int longestPath(
    String current, Map<String, List<String>> tree, 
    int pathLength, int best
) {
    if (current.equals("end")) {
        return Math.max(pathLength, best);
    }

    for (String child : tree.get(current)) {
        best = Math.max(
            best, longestPath(child, tree, pathLength + 1, best)
        );
    }

    return best;
}