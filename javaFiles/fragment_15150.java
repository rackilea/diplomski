public int timeofdayafternoonthsmon(Getset g) throws ClassNotFoundException, SQLException {
    // TODO Auto-generated method stub
    Connection con=Dbconnection.getConnection();
    String userid=g.getuserid();
    PreparedStatement pstmt=con.prepareStatement("select count(timeofday) from mealdb where timeofday=? and userid=?");
    pstmt.setString(1,"Afternoon");
    pstmt.setString(2,userid);

    // execute a query, not an update statement and fetch the result set
    ResultSet rs = stmt.executeQuery();
    // position to the first result, there must be one since count(timeofday) returns at least 0
    rs.next();

    System.out.println(""+rs.getInt(1));
    return rs.getInt(1);
}