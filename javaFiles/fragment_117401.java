List<String[]> fixtures = new ArrayList<>();
fixtures.add(new String [] {"60","52","0","0","1512230400"});
fixtures.add(new String [] {"76","52","1","1","1514044800"});
fixtures.add(new String [] {"42","52","4","1","1516464000"});

String query = 
  "INSERT INTO games (team1_id, team2_id, score1, score2, created_at)\n"
  + " VALUES (? ,?, ?, ?, ? )";
try(
  Connection con = DBConnector.connect();
  PreparedStatement stmt = con.prepareStatement(query);
) {
  for (String[] s : fixtures) {
    stmt.setString(1,s[0]);
    stmt.setString(2,s[1]);
    stmt.setString(3,s[2]);
    stmt.setString(4,s[3]);
    stmt.setString(5,s[4]);
    stmt.execute();
  }
  con.commit();
}