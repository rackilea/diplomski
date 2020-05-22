Set<Integer> intersection = new HashSet<>(lists.get(0))
for(List<Integer> list : lists) {
    Set<Integer> newIntersection = new HashSet<>();
    for(Integer i : list) {
        if(intersection.contains(i)) {
            newIntersections.add(i);
        }
    }
    intersection = newIntersection;
}