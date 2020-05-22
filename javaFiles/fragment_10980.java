public static int countMatches(BinaryNodeInterface<Integer> tree, Integer key)
{
    int matches = 0;
    if (tree == null) return 0;
    Queue<BinaryTreeNodeInterface<Integer>> queue = new LinkedList<BinaryTreeNodeInterface<Integer>>();
    queue.add(tree);
    while (!queue.isEmpty()) {
        BinaryTreeNodeInterface<Integer> current = queue.remove();
        if (current.getData().equals(key)) 
            matches++;
        if (current.getLeftChild() != null)
            queue.add(current.getLeftChild());
        if (current.getRightChild() != null)
            queue.add(current.getRightChild());
    }

    return matches;
}