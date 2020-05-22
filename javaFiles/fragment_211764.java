List<Integer> list = new LinkedList<>();
flatten(list, tree);

void flatten(List<Integer> list, Node tree) {
    if (tree == null) {
        list.add(null);
        return;
    }
    list.add(tree.data);
    flatten(tree.left);
    flatten(tree.right);
}