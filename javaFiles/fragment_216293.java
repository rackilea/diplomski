if (this.getRight() != null) {
    Node res = this.getRight().search(string);
    if (res != null) {
        return res;
    }
}
if (this.getLeft() != null) {
    return this.getLeft().search(string);
}
return null;