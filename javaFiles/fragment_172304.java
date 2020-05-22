public **List** getPath(TreeNode node) {
List<TreeNode> list = new ArrayList<TreeNode>();

**while (node != model.getRoot()) {**
    list.add(node);
    node = node.getParent();
}
    Collections.reverse(list);

    **return list;**
}

**for (List elem : f.getTreePaths()) {**
        elem.add(0, model.getRoot());
        tree.expandPath(new TreePath(elem.toArray());
        tree.scrollPathToVisible(elem);
}