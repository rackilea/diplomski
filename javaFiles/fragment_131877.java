public boolean isDegenerate() {
    if (this.left != null) {
        if (this.right != null) {
            return false; // not degenerate, has two children
        } else {
            return this.left.isDegenerate();
        }
    } else {
        if (this.right != null) {
            return this.right.isDegenerate();
        } else {
            return true; // we arrived at the bottom without seeing any node with two children
        }
    }
}