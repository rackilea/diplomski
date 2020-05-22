boolean hasResult = stmt.execute(
  "select * from table_1;\n" +
  "select * from table_2;");

while (hasResult) 
{
  rs = stmt.getResultSet();
  while (rs.next()) 
  {
    // process the result set
  }
  hasResult = stmt.getMoreResults();
}