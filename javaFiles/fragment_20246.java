for (int i = 0; i < NumberOfColumns; i++) {

    sql = "ALTER TABLE mydb.test ADD'" + i + "' VARCHAR(30)";
    stmt.executeUpdate(sql);
}
stmt.executeUpdate(sql);