public String getRow(int row) {
    if (row < desks.length) {
        return Arrays.toString(desks[row]);
    }
    return ""; // <-- or null, or throw an exception.
}