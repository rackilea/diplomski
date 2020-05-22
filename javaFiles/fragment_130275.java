private void checkAgainstModel(int firstRow, int endRow) {
    if (firstRow > endRow || firstRow < 0 || endRow < 0 ||
            firstRow > modelRowCount) {
        throw new IndexOutOfBoundsException("Invalid range");
    }
}