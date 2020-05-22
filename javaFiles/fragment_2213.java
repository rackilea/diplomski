int index(Object arrayToIndex, int... indices) {
    for (int i = 0; i < indices.length - 1; i++) {
        arrayToIndex = ((Object[]) arrayToIndex)[indices[i]];
    }
    return ((int[]) arrayToIndex)[indices[indices.length-1]];
}