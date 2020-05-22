public byte[] getBytes(int columnIndex) throws SQLException {

    Type sourceType = resultMetaData.columnTypes[columnIndex-1];
    if (sourceType.isLobType()){
        Blob b = getBlob(columnIndex);
        return b.getBytes(1, (int)b.length());
    }

    Object x = getColumnInType(columnIndex, Type.SQL_VARBINARY);

    if (x == null) {
        return null;
    }

    return ((BinaryData) x).getBytes();
}