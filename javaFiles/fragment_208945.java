public void removeRow(int rowNumber) throws SQLException {
    Connection con = ...;
    PreparedStatement ps = null;

    String keyValue = ...; // Get key value from the ArrayList

    try {
        ps = con.prepareStatement("DELETE from youDatabaseTabe where key=?");
        ps.setObject(1, keyValue);
        if (ps.executeUpdate() == 1) {
            data.remove(rowNumber);
            fireTableRowsDeleted(rowNumber, rowNumber);
        } else {
            throw new SQLException("Failed to remove row from database");
        }
    } finally {
        try {
            ps.close();
        } catch (Exception e) {
        }
    }
}