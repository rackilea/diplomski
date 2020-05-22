while (rs.next()) {
   int id = rs.getInt("ID");
   String title = rs.getString("CO1Name");
   String name = rs.getString("CO2Rating");
   // do stuff with this record
}