Timestamp prevtimeReg = null;
while (rs.next()) {
    int id = rs.getInt("Id");
    String userName = rs.getString("UserName");
    String firstName = rs.getString("FirstName");
    String surname = rs.getString("Surname");
    Timestamp nexttimeReg= rs.getTimestamp("TimeRegistered");
    //do your operation with previous time stamp
    Timestamp prevtimeReg = nexttimeReg;
 }