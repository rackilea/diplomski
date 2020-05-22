private String createInsertSql(ResultSetMetaData resultSetMetaData) throws SQLException
{
  StringBuffer insertSql = new StringBuffer("INSERT INTO ");
  StringBuffer values = new StringBuffer(" VALUES (");

  insertSql.append(resultSetMetaData.getTableName());

  for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
  {
    insertSql.append(resultSetMetaData.getColumnName(i));
    values.append("?");

    if (i <= resultSetMetaData.getColumnCount())
    {
      insertSql.append(", ");
      values.append(", ");
    }
    else 
    {
      insertSql.append(")");
      values.append(")");
    }
  }

  return insertSql.toString() + values.toString();
}