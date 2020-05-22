public static void visit(List<List<Integer>> tree, Visitor<List<Integer>> visitor) {
    visit0(tree, visitor, Collections.<Integer>emptyList());
}

private static void visit0(List<List<Integer>> tree, 
                           Visitor<List<Integer>> visitor, List<Integer> list) {
    if (tree.isEmpty()) {
       visitor.onList(list);
       return;
    }

    List<List<Integer>> tree2 = tree.subList(1, tree.size() - 1);
    List<Integer> ints = new ArrayList<Integer>(list);
    ints.add(0); // dummy entry.
    for(int n: tree.get(0)) {
        ints.set(ints.size()-1, n);
        visit0(tree2, visitor, ints);
    }
}