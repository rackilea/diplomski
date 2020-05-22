int getDepth() {
    int subTreeDepth;
    if (left == null && right == null) {
        subTreeDepth = 0;
    } else if (left == null) {
        subTreeDepth = right.getDepth();
    } else if (right == null) {
        subTreeDepth = left.getDepth();
    } else {
        subTreeDepth = Math.max(left.getDepth(), right.getDepth());
    }
    return 1 + subTreeDepth;
}