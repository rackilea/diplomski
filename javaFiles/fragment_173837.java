Connection conn = ...;
  Statement stmt = conn.createStatement();
  ResultSet rs = stmt.executeQuery
    ("select account_id, name from customers");
  Iterator rows = (new ResultSetDynaClass(rs)).iterator();
  while (rows.hasNext()) {
    DynaBean row = (DynaBean) rows.next();
    System.out.println("Account number is " +
                       row.get("account_id") +
                       " and name is " + row.get("name"));
  }
  rs.close();
  stmt.close();