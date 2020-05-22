public boolean shouldIterateChildren() {
    if (tree.getRowKey() == null) {
        return true;
    }

    if (tree.isLeaf()) {
        return false;
    }

    return traverseAll || tree.isExpanded();
}