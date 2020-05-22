private static void printForeignKeys(Connection connection, String tableName) throws SQLException {
    DatabaseMetaData metaData = connection.getMetaData();
    ResultSet foreignKeys = metaData.getImportedKeys(connection.getCatalog(), null, tableName);
    while (foreignKeys.next()) {
        String fkTableName = foreignKeys.getString("FKTABLE_NAME");
        String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
        String pkTableName = foreignKeys.getString("PKTABLE_NAME");
        String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
        System.out.println(fkTableName + "." + fkColumnName + " -> " + pkTableName + "." + pkColumnName);
    }
}