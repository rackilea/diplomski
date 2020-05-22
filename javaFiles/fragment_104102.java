private static boolean hasColumn (RestultSet rs, String column) {
    RestulSetMetaData md = rs.getMetaData();
    int colCount = md.getColumnCount();
    for (int i = 1; i <= colCount; ++i) { // Note that column indexes are 1-based
        if (column.equalsIgnoreCase(rs.getColumnName(i))) {
            return true;
        }
    }
    return false;
}