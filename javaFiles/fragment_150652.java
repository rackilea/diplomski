try(PreparedStatement ps = con.prepareStatement("update score set " + 
     " points = ? where name = ? and lastname = ? and points < ?") {
  ps.setInt(1, scorecard[TOTAL][i]);
  ps.setString(2, players[i].getName());
  ps.setString(3, players[i].getLastName());
  ps.setInt(4, scorecard[TOTAL][i]);
  ps.executeUpdate(); 
}