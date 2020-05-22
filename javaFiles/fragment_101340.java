String query2 = "select count(*) from biletbilgileri ...";
ResultSet rs1 = stmt1.executeQuery(query2);
rs1.next();
int count = rs1.getInt(1);
if (count == 0) {
  // empty
}