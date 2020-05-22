private static int extractValues(Node n, int[] results, int index) {
    if (n.getLeft() != null) {
        index = extractValues(n.getLeft(), results, index);
    }

    if (n.getRight() != null) {
        index = extractValues(n.getRight(), results, index);
    }

    results[index] = n.getValue();

    return index + 1;
}