@Override
public String toString() {
    StringBuilder string = new StringBuilder();
    toString(this.root, string);
    return string.toString();
}
private static <T> void toString(BSTNode<T> node, StringBuilder string) {
    string.append('{');
    if (node != null) {
        string.append(node.getData());
        string.append(", ");
        toString(node.getLeft(), string);
        string.append(", ");
        toString(node.getRight(), string);
    }
    string.append('}');
}