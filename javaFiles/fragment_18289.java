public String toString() {
    String out = "(";
    if (this.left != null) {
        out += left.toString() + ",";
    }
    out += this.data;
    if (this.right != null) {
        out += "," + right.toString();
    }
    return out + ")";
}