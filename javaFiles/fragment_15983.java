private String findPath(char input, HuffmanNode root, String path) {
    String result;
    if (! root.isLeaf()) {
        if ((result = findPath(input, root.left, path + '0')) == null) {
            result = findPath(input, root.right, path + '1');
        }
    }
    else {
        result = (input == root.character) ? path : null;
    }
    return result;
}