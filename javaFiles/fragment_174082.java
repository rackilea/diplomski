static Collection<ITreeNode<IProduct>> getOnLevel(
    ITree<IProduct> tree
,   int desiredLevel
) {
    List<ITreeNode<IProduct>> result = new ArrayList<>();
    findOneLevel(tree.getRoot(), desiredLevel, 0, result);
    return result;
}

static void findOnLevel(
    ITreeNode<IProduct> node
,   int desiredLevel
,   int currentLevel
,   List<ITreeNode<IProduct>> result
) {
    if (currentLevel == desiredLevel) {
        result.add(node);
        return;
    }
    Iterator<ITreeNode<IProduct>> iterator = node.getChildren().iterator();
    while(iterator.hasNext()) {
       findOnLevel(iterator.next(), desiredLevel, currentLevel+1, result);
    }
}