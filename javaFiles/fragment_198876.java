public Object[][] handle(ResultSet rs) throws SQLException {
        if (!rs.last()) { //If false, the result set is empty.
            System.out.println("result set is null");
            return null;
        }
        int rowCount = rs.getRow(); // You are pointing on the last row, so this will get the row number of the last row.
        rs.beforeFirst(); // Reset your cursor.
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        Object[][] result = new Object[rowCount][columnCount];
        int i = 0;
        while (rs.next()) {
            for (int j = 0; j < columnCount; j++) {
                result[i][j] = rs.getObject(j);
            }
        }
        return result;
}