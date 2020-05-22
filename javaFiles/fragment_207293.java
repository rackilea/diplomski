int height(BinaryTree bt) {
    if (bt == null) {
       return 0;
    }
    return 1 + Math.max(height(bt.getLeft()), height());
}