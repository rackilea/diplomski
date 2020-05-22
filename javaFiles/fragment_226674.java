public static void main(String[] args) {
    Map<Integer, List<Character>> paths = new LinkedHashMap<>();
    paths.put(1, Arrays.asList('R', 'R', 'R', 'R', 'P', 'P', 'L', 'L', 'P', 'P'));
    paths.put(2, Arrays.asList('R', 'R', 'R', 'R', 'P', 'P', 'R', 'R', 'R', 'R', 'P', 'P', 'L', 'L', 'L', 'L', 'L', 'L'));
    paths.put(3, Arrays.asList('R', 'R', 'R', 'R', 'P', 'P', 'R', 'R', 'R', 'R', 'P', 'P', 'P', 'P', 'L', 'L', 'L', 'L', 'L', 'L', 'P', 'P'));

    System.out.println("Path " + bestPath(paths, DrivingDirection.RIGHT_HANDED) + " is the best for " + DrivingDirection.RIGHT_HANDED);
    System.out.println("Path " + bestPath(paths, DrivingDirection.LEFT_HANDED) + " is the best for " + DrivingDirection.LEFT_HANDED);
}

private static List<Character> getTurnPreferences(DrivingDirection drivingDirection) {
    return drivingDirection == DrivingDirection.RIGHT_HANDED
            ? Arrays.asList('P', 'R', 'L')
            : Arrays.asList('P', 'L', 'R');
}

private enum DrivingDirection {
    RIGHT_HANDED,
    LEFT_HANDED
}

private static int bestPath(Map<Integer, List<Character>> paths, DrivingDirection drivingDirection) {
    List<Character> turnPreference = getTurnPreferences(drivingDirection);
    final AtomicInteger i = new AtomicInteger(0);
    while (paths.size() > 1) {
        Map<Integer, List<Character>> tempMap = eliminateUnpreferredPaths(paths, turnPreference, i);
        if (tempMap.size() == 0) return getShortestPath(paths).getKey(); // when all paths are bad
        i.incrementAndGet();
        Optional<Map.Entry<Integer, List<Character>>> pathWithNoMoreDirections = getPathWithNoMoreDirectionsLeft(i, tempMap);
        if (pathWithNoMoreDirections.isPresent()) return pathWithNoMoreDirections.get().getKey();
        paths = tempMap;
    }
    return paths.keySet().iterator().next();
}

private static Optional<Map.Entry<Integer, List<Character>>> getPathWithNoMoreDirectionsLeft(
        AtomicInteger i, Map<Integer, List<Character>> tempMap) {
    return tempMap.entrySet().stream()
            .filter(e -> e.getValue().size() == i.get())
            .findFirst();
}

private static Map.Entry<Integer, List<Character>> getShortestPath(Map<Integer, List<Character>> paths) {
    return paths.entrySet().stream().min(Comparator.comparingInt(e -> e.getValue().size())).get();
}

private static Map<Integer, List<Character>> eliminateUnpreferredPaths(
        Map<Integer, List<Character>> paths, List<Character> turnPreference, AtomicInteger i) {
    Map<Integer, List<Character>> tempMap = null;
    for (int j = 0; j < turnPreference.size(); j++) {
        final int finalJ = j;
        tempMap = paths.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > i.get() && e.getValue().get(i.get()).equals(turnPreference.get(finalJ)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (tempMap.size() > 0) break;
    }
    return tempMap;
}