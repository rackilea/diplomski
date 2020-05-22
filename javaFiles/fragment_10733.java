Statement qry = conn.createStatement();
String sql = "select id from CONSTITUENTS where manager = 'abc' limit 1";
ResultSet rset = qry.executeQuery(sql);
while (rset.next()) {
    int id = rset.getInt("id");
    System.out.println(id);
    // we can't reuse the same Statement here so we need to create a new one
    conn.createStatement().executeUpdate("insert into PAYREQUESTS ...");
}