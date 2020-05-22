@Override
public String toString() {
    return toString(new StringBuilder(), this.root).toString();
}
private static <T> StringBuilder toString(StringBuilder string, BSTNode<T> node) {
    string.append('{');
    if (node != null) {
        string.append(node.getData());
        toString(string.append(", "), node.getLeft());
        toString(string.append(", "), node.getRight());
    }
    return string.append('}');
}