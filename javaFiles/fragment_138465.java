public String toIndentedString() {
    return _toIndentedString() + '\n';
}

private String _toIndentedString() {
    StringBuilder sb = new StringBuilder(rootValue.toString());
    for (Tree<T> child : children) {
        sb.append('\n');
        sb.append(child._toIndentedString().replaceAll("(?m)^", "  "));
    }
    return sb.toString();
}