TreeNode newNode = new DefaultTreeNode(a, rootNode);

    Collection<Catagary> c=port.viewCategoryByPId(a);

    for (Catagary tt : c) {

        TreeNode newNode2 = createTree(tt.getId(), newNode);
    }

    return newNode;
}