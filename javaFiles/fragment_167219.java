public static int getLimit(Sheet s, int startNumber) {
    int limit;
    int countRows = s.getRows();
    if (startNumber+maxRecords<=countRows) {
        limit = startNumber + maxRecords;
    } else {
        limit = startNumber + (countRows-startNumber);
    }
    return limit;
}