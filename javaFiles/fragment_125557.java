ResultSet rs = stmt.executeQuery("SELECT * FROM setoffunc()");
while (rs.next()) {
   // read results
}
rs.close();
stmt.close();