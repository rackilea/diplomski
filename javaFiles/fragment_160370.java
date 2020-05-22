String sql = "SELECT TABLE_SCHEMA AS TABLE_CAT, NULL AS TABLE_SCHEM, TABLE_NAME,"
        + "COLUMN_NAME, NULL AS GRANTOR, GRANTEE, PRIVILEGE_TYPE AS PRIVILEGE, IS_GRANTABLE FROM INFORMATION_SCHEMA.COLUMN_PRIVILEGES WHERE "
        + "TABLE_SCHEMA LIKE ? AND TABLE_NAME =? AND COLUMN_NAME LIKE ? ORDER BY COLUMN_NAME, PRIVILEGE_TYPE";

java.sql.PreparedStatement pStmt = null;

try {
    pStmt = prepareMetaDataSafeStatement(sql);

    if (catalog != null) {
        pStmt.setString(1, catalog);
    } else {
        pStmt.setString(1, "%");
    }

    pStmt.setString(2, table);
    pStmt.setString(3, columnNamePattern);