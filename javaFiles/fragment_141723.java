private int traverseInorder(Node n, int[] array, int index) {
    if (n != null) {
        index = traverseInorder(n.left, array, index);
        array[index++] = n.value;
        index = traverseInorder(n.right, array, index);
    }
    return index;
}