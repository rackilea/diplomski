public void step(Map<Integer, List<Integer>> tree, List<Integer> nodes, Integer key) {
    if (nodes.contains(key)) {
        // skip node which we already processed
        return;
    }
    nodes.add(key);

    List<Integer> children = tree.get(key);
    // add sanity checks here if you expect inconsistent data
    for (Integer child : children) {
        step(tree, nodes, child);
    }
}