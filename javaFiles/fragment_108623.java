public byte[] getBytes(int columnIndex) throws SQLException {

    Object x = getColumnInType(columnIndex, Type.SQL_VARBINARY);

    if (x == null) {
        return null;
    }

    return ((BinaryData) x).getBytes();
}