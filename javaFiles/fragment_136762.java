public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.left != null) {
        sb.append(this.left);
        sb.append(' ');
    }
    sb.append(this.val);
    if (this.right != null) {
        sb.append(' ');
        sb.append(this.right);
    }
    return sb.toString();
}