public void recursivePlease(List<SortedSet<Integer>> trees) {
    List<SortedSet<Integer>> nextLevelTrees = new ArrayList<>();
    for (SortedSet<Integer> t : trees) {
        if (t.size() <= 1) { //base case
            System.out.print("" + t.first() + ' ');
        } else {
            Integer root = getRoot(t);
            System.out.print("" + root + ' ');
            SortedSet<Integer> headSet = t.headSet(root);
            if (! headSet.isEmpty()) {
                nextLevelTrees.add(headSet);
            }
            SortedSet<Integer> tailSet = t.tailSet(root + 1);
            if (! tailSet.isEmpty()) {
                nextLevelTrees.add(tailSet);
            }
        }
    }
    System.out.println();
    if (! nextLevelTrees.isEmpty()) {
        recursivePlease(nextLevelTrees);
    }
}