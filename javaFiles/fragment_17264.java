public static void setInteger(PreparedStatement stmt, int index, Integer value) {
    if (value==null) {
        stmt.setNull(index, Types.INTEGER);
    } else {
        stmt.setInt(index, value);
    }
}