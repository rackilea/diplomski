PreparedStatement statement = null;
try{
    statement = con.prepareStatement("SELECT * FROM guest WHERE guestID=?");
    statement.setInt(1, guestID);
    ResultSet rs = statement.executeQuery();
    while(rs.next()){
        this.guestID = rs.getInt(1);
        this.roomType = rs.getString(2);
        this.roomNo = rs.getInt(3);
    }
}catch(Exception e){
    System.out.print(e);
} finally {
    try {
        statement.close();
    }catch(Exception e){
    }
}