int weightedSumAtAllLevels(BTNode node, int level) {
    if (node != null) {
        return level * node.getKey() +
               weightedSumAtAllLevels(node.getLeftChild(), level + 1) +
               weightedSumAtAllLevels(node.getRightChild(), level + 1);
    } else {
        return 0;
    }
}