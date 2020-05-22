public java.sql.ResultSet getSchemas() throws SQLException {
    Field[] fields = new Field[2];
    fields[0] = new Field("", "TABLE_SCHEM", java.sql.Types.CHAR, 0);
    fields[1] = new Field("", "TABLE_CATALOG", java.sql.Types.CHAR, 0);

    ArrayList<ResultSetRow> tuples = new ArrayList<ResultSetRow>();
    java.sql.ResultSet results = buildResultSet(fields, tuples);

    return results;
}