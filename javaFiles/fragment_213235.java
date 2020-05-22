public static org.apache.myfaces.tobago.model.TreePath convertPath(TreeNode node) {
    List<Integer> list = new ArrayList<>();
    TreeNode current = node;
    while (current.getParent() != null) {
        list.add(0, current.getParent().getIndex(current));
        current = current.getParent();
    }
    return new org.apache.myfaces.tobago.model.TreePath(list);
}