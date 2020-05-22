public void prepareInsertStatement(Connection conn, Strint table, String number) {
    String insertData = "INSERT INTO `database`.`"+table+"`
    (`person_id`,`Date`,`amount+"number"') VALUES "+
    "(?,?,?) ON DUPLICATE KEY UPDATE " +
    "`person_id` = ? , " +
    "`Date` = ? , " +
    "`amount+"number"' = ? ; ";
    PreparedStatement insertDataStmt = conn.prepareStatement(insertData);

    return insertDataStmt;
}