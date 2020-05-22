public static Flight selectFlight() throws SQLException{  // no param needed
  PreparedStatement ps = null;
  ResultSet rs = null;

  // I guess that this will not be the query you want in the end
  String q1 = "Select * from Flights1 f order by f.time";        
  Flight flight1 = null;
  try{
    ps = connection.prepareStatement(q1);
    rs = ps.executeQuery();
    if (rs.next()){  // only returning one object so no needed for while
      flight1 = new Flight();
      flight1.setflno(rs.getInt(1));
      flight1.settime(rs.getTimestamp(2));
      System.out.println(“new flight:” +flight1.getflno()); Correct output printed here
    }
  }
  finally{
    closeResultSet(rs);
    closePreparedStatement(ps);
  }
  return flight1;
}