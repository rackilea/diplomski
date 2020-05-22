public int maxLevel() {
    int maxChildLevel = 0;
    for (Node child : children) {
        maxChildLevel = Math.max(maxChildLevel, child.maxLevel());
    }
    return maxChildLevel + 1;
}