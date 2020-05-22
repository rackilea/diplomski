ResultSet rs2 = stmt.executeQuery("select * from teacher");  

//rs2.next(); // reads one row!
  rs2.first();


try {
  rs2.getInt("fee");
  System.out.println("found");
  stmt.executeUpdate("alter table teacher drop fee  ");
} catch(SQLException e) {
  System.out.println("not found");
  System.err.print(e);
  stmt.executeUpdate("alter table teacher add fee int ");
}