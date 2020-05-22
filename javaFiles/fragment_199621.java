String sql = 
  "with data (id, col1) as ( \n" +
  "  values (?, ?) \n" +
  "), updated as ( \n" +
  " \n" +
  "  UPDATE foo  \n" +
  "     SET field = (select col1 from data)  \n" +
  "  WHERE id  = (select id from data) \n" +
  ") \n" +
  "insert into foo  \n" +
  "select id, col1  \n" +
  "from data  \n" +
  "where not exists (select 1  \n" +
  "                  from foo \n" +
  "                  where id = (select id from data))";


pstmt = connection.prepareStatement(sql);
pstmt.setInt(1, 3);
pstmt.setString(2, "C");
pstmt.executeUpdate();