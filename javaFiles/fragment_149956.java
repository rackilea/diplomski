List<TreeNode> allBinaryTrees(int numberOfLeaves) {
    if (numberOfLeaves < 1) {
        throw new IllegalArgumentException("Number of leaves must be positive");
    }
    List<TreeNode> result = new ArrayList<>();
    if (numberOfLeaves == 1) {
        // return a single tree consisting of a single leaf node
        result.add(new Leaf());
        return result;
    }
    for (int sizeOfLeftSubtree = 1; sizeOfLeftSubtree < numberOfLeaves - 1; sizeOfLeftSubtree++) {
        List<TreeNode> possibleLeftSubtrees = allBinaryTrees(sizeOfLeftSubtree);
        List<TreeNode> possibleRightSubtrees = allBinaryTrees(numberOfLeaves - sizeOfLeftSubtree);
        for (TreeNode lt : possibleLeftSubtrees) {
            for (TreeNode rt : possibleRightSubtrees) {
                // make a tree of a node with lt and rt as subtrees,
                // and add it to the result
                result.add(new InternalNode(lt, rt));
            }
        }
    }
    return result;
}