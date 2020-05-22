static int rankOf(String s, Node root) {
    if(root == null) {
        return -1;
    }

    if(root.value.equals(s)) {
        return size(root);
    }

    int result;
    if(s.compareTo(root.value) > 0) {
        result = rankOf(s, root.right);
    } else {
        result = rankOf(s, root.left);
    }
    return result;
}